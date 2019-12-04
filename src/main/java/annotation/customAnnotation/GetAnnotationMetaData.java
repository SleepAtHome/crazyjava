package annotation.customAnnotation;

import java.lang.annotation.Annotation;

/**
 * ClassName: GetAnnotationMetaData
 * Description: 得到Annotation中的元数据
 * 可以将Annotation强制类型转换成所需要的Annotation类型，然后通过Annotation对象的抽象方法来访问这些元数据。
 * date: 2019/12/4 23:26
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class GetAnnotationMetaData {
    public static void main(String[] args) throws NoSuchMethodException {
        TestMyTagAnnotation t = new TestMyTagAnnotation();
        Annotation[] annotations = t.getClass().getMethod("info").getAnnotations();
        for (Annotation a: annotations) {
            // 如果Annotation是MyTag类型
            if (a instanceof MyTag) {
                System.out.println("Tag is: "+ a);
                // 将a强转为MyTag类型,并输出两个成员变量的值
                System.out.println("a.name(): "+ ((MyTag) a).name());
                System.out.println("a.age(): "+ ((MyTag) a).age());
            }

            // 如果有MyTag2类型..类似..
        }
    }
}
