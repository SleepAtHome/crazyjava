package exception.handleException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ClassName: AccessExceptionMsg
 * Description: 异常对象的使用，访问异常信息
 * date:
 * @author jingyuankui
 * @since JDK 1.8
 */
public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("Non-existent.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage()); // getMessage()：返回该异常的详细描述字符串
            System.out.println("======");
            ioe.printStackTrace();// 将异常的跟踪栈信息输出到标准错误输出

            ioe.getStackTrace();// 返回该异常的跟踪栈信息
        }
    }
}
