package exception.exceptionSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ClassName: ThrowsTest2
 * Description: 抛出异常2
 * date: 2019/11/8 21:11
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ThrowsTest2 {
    public static void main(String[] args) throws Exception{
        // 因为这个方法可能会抛出异常，所以这里要么用try、catch块包住，要么抛出, 否则编译不通过
        test();
    }

    private static void test() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("FileNotFoundException.txt");
    }
}
