package annotation.aptAnnotation;

import java.lang.annotation.*;

/**
 * ClassName: Property
 * Description: 用于修饰普通成员属性
 * date: 2019/12/7 16:06
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Property {
    String column();
    String type();
}
