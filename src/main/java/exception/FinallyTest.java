package exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassName: FinallyTest
 * Description: 测试Finally块使用
 * date: 2019/11/7 22:28
 * @author jyk
 * @since JDK 1.8
 */
public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            // 即使return，finally块中的代码也会执行
            return;

            // 如果不使用return，使用exit退出虚拟机，则finally块中的代码就不再会被执行
            // System.exit(1);
        } finally {
            if (fi != null) {
                // 异常处理可以嵌套，但别太多（不优雅）
                try {
                    fi.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            System.out.println("执行finally块");
        }
    }
}
