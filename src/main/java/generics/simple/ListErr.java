package generics.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ListErr
 * Description: 测试编译时不检查类型的异常
 * date: 2019/12/26 23:44
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ListErr {
    public static void main(String[] args) {
        // 本来打算放String类型的
        List strlist = new ArrayList();
        strlist.add("JYK");
        strlist.add("ABC");
        // 放入了一个Integer
        strlist.add(1);

        for (int i=0; i<strlist.size(); i++) {
            // 取出，需要强转，危险，发生ClassCastException异常，因为尝试把Integer强转成String
            String string = (String) strlist.get(i);
        }
    }
}
