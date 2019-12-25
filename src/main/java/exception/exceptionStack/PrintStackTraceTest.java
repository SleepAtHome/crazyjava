package exception.exceptionStack;

/**
 * ClassName: PrintStackTraceTest
 * Description: 测试异常对象的printStackTrace()方法
 * date: 2019/12/25 11:22
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }

    public static void firstMethod() {
        secondMethod();
    }
    public static void secondMethod() {
        thirdMethod();
    }
    public static void thirdMethod() {
        throw new SelfException("自定义异常信息");
    }
}

class SelfException extends RuntimeException {
    public SelfException() {
    }

    public SelfException(String message) {
        super(message);
    }

    public SelfException(Throwable cause) {
        super(cause);
    }
}
