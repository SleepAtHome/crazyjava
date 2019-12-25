package exception.useThrow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * ClassName: ThrowTest2
 * Description: jdk1.7后 用Exception捕获再抛出，外面也能捕获到真实抛出的异常了
 * date: 2019/12/25 10:38
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThrowTest2 {
    /**
     * 会检查异常的实际类型
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new FileOutputStream("ThrowTest2.txt");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
