package annotation.aptAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

/**
 * ClassName: HibernateXMLAnnotationProcessor
 * Description: 一个Annotation处理器
 * 功能：根据一个类的Annotation来生成一个Hibernate映射文件（一份XML文件）
 * 使用RoundEnvironment来获取Annotation信息
 *
 * 使用方式：javac -processor HibernateXMLAnnotationProcessor Person.java
 *
 * date: 2019/12/7 16:13
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
// 指定可处理@Persistent、@ID、@Property这三个Annotation
@SupportedAnnotationTypes({"Persistent","Id","Property"})
public class HibernateXmlAnnotationProcessor extends AbstractProcessor {
    /**
     * 循环处理每个要处理的程序对象
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 输出流，用于输出文件
        PrintStream ps = null;
        try {
            // 遍历每个被@Persistent修饰的class文件
            for (Element t: roundEnv.getElementsAnnotatedWith(Persistent.class)) {
                // 类名
                Name clazzName = t.getSimpleName();
                // 获取类定义前的@Persistent
                Persistent per = t.getAnnotation(Persistent.class);
                // 输出流
                ps = new PrintStream(new FileOutputStream(clazzName+".hbm.xml"));

                // 输出文件头
                ps.println("<?xml version='1.0' encoding='UTF-8'?>");
                ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
                ps.println("          \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
                ps.println("          \"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\">");
                ps.println();
                ps.println("<hibernate-mapping>");
                // 类名、表名
                ps.println("    <class name=\""+t+"\" table=\""+per.table()+"\">");

                // 遍历t这个类中所有的元素
                for (Element f: t.getEnclosedElements()) {
                    // 只处理Filed上的Annotation
                    if (f.getKind() == ElementKind.FIELD) {

                        // 获取Field定义前的@Id
                        Id id = f.getAnnotation(Id.class);
                        // 当有@Id的时候，输出对应信息
                        if (id != null) {
                            ps.println("        <id name=\""+f.getSimpleName()+"\" column=\""+id.column()+"\" type=\""+id.type()+"\">");
                            ps.println("<generator class=\""+id.generator()+"\"></generator>");
                            ps.println("        </id>");
                        }

                        // 获取Field定义前的@Property
                        Property p = f.getAnnotation(Property.class);
                        if (p != null) {
                            ps.println("        <property name=\""+f.getSimpleName()+"\" column=\""+p.column()+"\" type=\""+p.type()+"\"></property>");
                        }
                    }
                }
                ps.println("    </class>");
                ps.println();
                ps.println("</hibernate-mapping>");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
