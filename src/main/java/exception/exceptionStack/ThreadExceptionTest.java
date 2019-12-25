package exception.exceptionStack;

/**
 * ClassName: ThreadExceptionTest
 * Description: 多线程异常情形
 * date: 2019/12/25 11:28
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThreadExceptionTest implements Runnable{

    @Override
    public void run() {
        firstMethod();
    }

    public void firstMethod() {
        secondMethod();
    }

    private void secondMethod() {
        int a = 5;
        int b = 0;
        int c = a / b;
    }

    public static void main(String[] args) {
        new Thread(new ThreadExceptionTest()).start();
    }
}
