package annotation.metaAnnotation;

import java.lang.annotation.*;

/**
 * ClassName: Testable
 * Description: 使用@Documented的注解
 * date: 2019/12/3 0:28
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Testable {
}
