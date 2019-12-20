package clazzLoad_reflect.generics.genericClass;

import javax.swing.*;
import java.util.Date;

/**
 * @description: 测试JYKObjectFactory1、JYKObjectFactory2
 * @author: Jingyuankui
 * @time: 2019/12/20 14:58
 */
public class TestFactory {
    public static void main(String[] args) {
        // 使用JYKObjectFactory1，需要用括号强转，不安全
        Date d1 = (Date) JYKObjectFactory1.getInstance("java.util.Date");
        // 可能会出现以下代码，很危险，编译的时候发现不了
        // JFrame jf1 = (JFrame) JYKObjectFactory1.getInstance("java.util.Date");

        // 使用JYKObjectFactory2，不需要用括号强转，安全（使用泛型）
        Date d2 = JYKObjectFactory2.getInstance(Date.class);
        JFrame jf2 = JYKObjectFactory2.getInstance(JFrame.class);
    }
}
