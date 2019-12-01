package annotation.baseAnnotation.heapPollution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: ErrorUtilsTest
 * Description: 执行"堆污染" 情况2
 * date: 2019/12/1 23:59
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ErrorUtilsTest {
    public static void main(String[] args) {
        /*
        调用方法时异常
        故意利用了"堆污染"，java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
         */
        ErrorUtils.faultyMethod(Arrays.asList("Hello"), Arrays.asList("World!"));
    }
}
