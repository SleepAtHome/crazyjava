package annotation.customAnnotation.useAnnotation1;

/**
 * ClassName: MyTest
 * Description: 这个类有8个方法，其中4个使用@Testable
 * date: 2019/12/4 23:47
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class MyTest {
    @Testable
    public static void m1() {}
    public static void m2() {}
    @Testable
    public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4() {}
    @Testable
    public static void m5() {}
    public static void m6() {}
    @Testable
    public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() {}
}
