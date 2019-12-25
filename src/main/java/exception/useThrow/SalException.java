package exception.useThrow;

/**
 * ClassName: SalException
 * Description: 自定义一个异常，
 * 可以 -封装原始异常 -接收异常对象并传递
 * date: 2019/12/25 10:56
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class SalException extends Exception{
    public SalException() {
    }

    public SalException(String message) {
        super(message);
    }

    /**
     * 可以接收一个异常对象
     * @param cause
     */
    public SalException(Throwable cause) {
        super(cause);
    }
}
