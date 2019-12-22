package exception.exceptionSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ClassName: ThrowsTest
 * Description: 抛出异常
 * date: 2019/11/8 21:09
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThrowsTest {
    public static void main(String[] args) throws FileNotFoundException {
        // 找不到这个文件的时候会抛出异常
        FileInputStream fis = new FileInputStream("FileNotFoundException.txt");
    }
}
