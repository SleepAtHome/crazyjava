package annotation.metaAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: MetaAnnotationTest
 * Description: 使用@Target元数据Annotation
 *
 * date: 2019/12/2 23:25
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Target(ElementType.METHOD) // 这个@MetaAnnotationTestTarget只能修饰方法
public @interface MetaAnnotationTestTarget { }
