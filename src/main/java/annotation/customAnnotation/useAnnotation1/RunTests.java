package annotation.customAnnotation.useAnnotation1;

/**
 * ClassName: RunTests
 * Description: 执行使用Annotation的测试
 * date: 2019/12/5 0:01
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        // 调用这个方法，就会执行对应类里使用@Testable注解的方法
        ProcessorTest.process("annotation.customAnnotation.useAnnotation1.MyTest");
    }
}
