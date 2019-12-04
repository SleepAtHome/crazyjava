package annotation.customAnnotation;

import java.lang.annotation.Documented;

/**
 * ClassName: TestMyTagAnnotation
 * Description: 测试自定义Annotation @MyTag
 * date: 2019/12/4 22:00
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class TestMyTagAnnotation {
    // 使用带成员变量的Annotation时，需要为成员变量赋值
    @MyTag(name = "jyk2", age = 100)
    public void info() {
    }
}
