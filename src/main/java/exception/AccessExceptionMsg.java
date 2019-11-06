package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage()); // getMessage()：返回该异常的详细描述字符串
            System.out.println("======");
            ioe.printStackTrace();// 将异常的跟踪栈信息输出到标准错误输出

            ioe.getStackTrace();// 返回该异常的跟踪栈信息
        }
    }
}
