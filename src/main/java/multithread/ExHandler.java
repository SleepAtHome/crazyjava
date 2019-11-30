package multithread;

/**
 * @description: 线程异常的处理
 * @author: Jingyuankui
 * @time: 2019/11/30 12:20
 */
public class ExHandler {
    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(new JYKThreadExceptionHandler());
        int a = 5/0;
        System.out.println("程序正常结束！");
    }
}

/**
 * 定义自己的异常处理器，依然会向上传播，与catch不同
 */
class JYKThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t +"线程 出现了异常：" + e);
    }
}
