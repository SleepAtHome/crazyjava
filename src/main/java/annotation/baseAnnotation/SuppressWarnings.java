package annotation.baseAnnotation;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SuppressWarnings
 * Description: 使用@SuppressWarnings抑制编译器警告
 * date: 2019/12/1 10:42
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@java.lang.SuppressWarnings(value = "unchecked")
public class SuppressWarnings {
    public static void main(String[] args) {
        /*
         这里没有使用泛型，所以本来应当产生警告:
         Information:java: D:\...\SuppressWarnings.java使用了未经检查或不安全的操作。

         但是这里使用@SuppressWarnings以后就没有告警了
         */
        List<String> list = new ArrayList();
    }
}
