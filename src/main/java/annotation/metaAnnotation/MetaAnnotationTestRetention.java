package annotation.metaAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ClassName: MetaAnnotationTest
 * Description: 使用@Retention元数据Annotation
 *
 * @Retention(value = RetentionPolicy.RUNTIME) 或是 @Retention(RetentionPolicy.RUNTIME)
 *
 * date: 2019/12/2 23:25
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Retention(value = RetentionPolicy.RUNTIME) // @MetaAnnotationTestRetention可以通过反射获取此Annotation信息
public @interface MetaAnnotationTestRetention { }
