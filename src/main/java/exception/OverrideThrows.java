package exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassName: OverrideThrows
 * Description: 子父类 抛异常范围
 * date: 2019/11/8 21:15
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class OverrideThrows {
    // 父类的异常必须要比子类范围大
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream("haha.txt");
    }
}

class Sub extends OverrideThrows {
    @Override
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("haha.txt");
    }
}
