package exception;

import java.io.*;

/**
 * ClassName: AutoCloseTest
 * Description: 自动关闭资源的try语句(java1.7+)
 * date: 2019/11/7 22:47
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        try(
                // 声明、初始化两个可关闭资源（try语句会自动关闭这两个资源）
                // 这两个类都实现了Closeable接口，所以可以自动关闭
                BufferedReader br = new BufferedReader(new FileReader("cc.txt"));
                PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))
        ) {
            System.out.println(br.readLine());
            ps.println("景元奎正在学习");
        }
    }
}
