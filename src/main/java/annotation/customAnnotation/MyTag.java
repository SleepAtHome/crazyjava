package annotation.customAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ClassName: MyTag
 * Description: 自定义Annotation
 * Annotation可以带成员变量：在Annotation中以无形参的方法形式来声明，其方法名和返回值定义了该成员变量的名字和类型。
 *
 * date: 2019/12/4 21:58
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag {
    // 定义成员变量
    String name();
    // 也可以给成员变量指定初始值
    int age() default 23;
}
