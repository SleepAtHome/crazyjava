package clazzLoad_reflect.check_information_by_reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassName: ClassTest
 * Description:
 * date: 2019/12/15 17:40
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@SuppressWarnings(value = "unchecked")
@Deprecated
public class ClassTest {

    private ClassTest() { }
    public ClassTest(String name) {
        System.out.println("执行有参构造器");
    }

    public void info() {
        System.out.println("执行无参info()方法");
    }

    public void info(String string) {
        System.out.println("执行有参的info()方法，参数值为"+string);
    }

    /**
     * 内部类
     */
    class Inner {}

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        Class<ClassTest> clazz = ClassTest.class;

        // 获取ClassTest的构造器们..
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器如下：");
        for (Constructor c: constructors) {
            System.out.println(c);
        }
        Constructor[] publicCons = clazz.getConstructors();
        System.out.println("ClassTest的全部public构造器如下：");
        for (Constructor c: publicCons) {
            System.out.println(c);
        }

        // 获取ClassTest的方法们..
        Method[] methods = clazz.getMethods();
        System.out.println("ClassTest的全部public方法如下：");
        for (Method m: methods) {
            System.out.println(m);
        }
        System.out.println("ClassTest里带一个字符串参数的info方法为："+clazz.getMethod("info", String.class));

        // 获取ClassTest的注解们...
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("ClassTest的全部注解如下：");
        for (Annotation a: annotations) {
            System.out.println(a);
        }
        // 这里获取的值为null，因为@SuppressWarnings的@Retention(RetentionPolicy.SOURCE)表示此注解只保留在源码
        System.out.println("ClassTest上@SuppressWarnings的注解为："+clazz.getAnnotation(SuppressWarnings.class));

        // 获取ClassTest对象所对应的全部内部类
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下：");
        for (Class c: inners) {
            System.out.println(c);
        }
        // 使用Class.forName()方法加载ClassTest的Inner内部类，这里要写全类名
        Class inClazz = Class.forName("clazzLoad_reflect.check_information_by_reflect.ClassTest$Inner");
        // 使用getDeclaringClass()方法通过内部类获得外部类
        System.out.println("inClazz对应的外部类为："+inClazz.getDeclaringClass());

        System.out.println("ClassTest的包为："+clazz.getPackage());
        System.out.println("ClassTest的父类为："+clazz.getSuperclass());

    }

}
