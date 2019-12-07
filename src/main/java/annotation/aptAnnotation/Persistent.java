package annotation.aptAnnotation;

import java.lang.annotation.*;

/**
 * ClassName: Persistent
 * Description: 用于修饰持久化类
 * date: 2019/12/7 15:51
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Persistent {
    String table();
}
