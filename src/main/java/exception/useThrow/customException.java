package exception.useThrow;

/**
 * ClassName: customException
 * Description: 自定义异常（需要有两个构造器）
 * date: 2019/12/24 22:00
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class customException extends Exception {
    public customException() {
    }

    public customException(String message) {
        super(message);
    }
}
