package annotation.aptAnnotation;

import java.lang.annotation.*;

/**
 * ClassName: Id
 * Description: 用于修饰标识属性
 * date: 2019/12/7 16:03
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Id {
    String column();
    String type();
    String generator();
}
