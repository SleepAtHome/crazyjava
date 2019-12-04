package annotation.customAnnotation.useAnnotation1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Testable
 * Description: 一个标记Annotation，作用是标记哪些方法是可测试的
 * 不包含任何成员变量
 * date: 2019/12/4 23:44
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testable {
}
