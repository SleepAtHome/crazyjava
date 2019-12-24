package exception.useThrow;

/**
 * ClassName: ThrowTest
 * Description: 测试抛出异常（Checked异常/Runtime异常）
 * date: 2019/12/24 21:48
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThrowTest {
    public static void main(String[] args) {
        try {
            // 必须捕获
            throwChecked(-3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 可以捕获也可以不理会
        throwRuntime(3);
    }

    /**
     * 抛出Checked异常，要显式处理
     * @param a
     * @throws Exception
     */
    public static void  throwChecked(int a) throws Exception {
        if (a > 0) {
            throw new Exception("a>0，不符合要求,throwChecked");
        }
    }

    /**
     * 抛出Runtime异常，无需要显式处理
     * @param a
     */
    public static void throwRuntime(int a) {
        if (a > 0) {
            throw new RuntimeException("a>0，不符合要求,throwRuntime");
        }
    }
}
