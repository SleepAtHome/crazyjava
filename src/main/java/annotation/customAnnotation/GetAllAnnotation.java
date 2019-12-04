package annotation.customAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ClassName: GetAllAnnotation
 * Description: 获取info方法上所有的Annotation
 * date: 2019/12/4 23:13
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class GetAllAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 得到TestMyTagAnnotation类中info()方法上的所有的Annotation（注意一定要在使用到的Annotation上使用@Retention(RetentionPolicy.RUNTIME)）
        Annotation[] annotations = Class.forName("annotation.customAnnotation.TestMyTagAnnotation").getMethod("info").getAnnotations();
        for (Annotation a: annotations) {
            System.out.println(a);
        }
    }
}
