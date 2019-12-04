package annotation.metaAnnotation;

import java.lang.annotation.*;

/**
 * @description: 使用@Inherited   被此Annotation修饰的Annotation将具有继承性。
 * @author: Jingyuankui
 * @time: 2019/12/4 12:51
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {
}
