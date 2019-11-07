package exception;

/**
 * ClassName: FinallyFlowTest
 * Description: 在finally块中使用return或者throw导致原本的try、catch块中的return、throw语句失效。
 * date: 2019/11/7 22:33
 * @author jingyuankui
 * @since JDK 1.8
 */
public class FinallyFlowTest {
    public static void main(String[] args) throws Exception{
        boolean a = test();
        System.out.println(a);
    }

    private static boolean test() {
        try {
            // 因为finally包含了return，所以这里的return失效了
            return true;
        }finally {
            return false;
        }
    }
}
