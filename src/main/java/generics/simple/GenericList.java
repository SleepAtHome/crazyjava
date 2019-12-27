package generics.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenericList
 * Description: 使用泛型
 * date: 2019/12/27 22:00
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class GenericList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("JYK");
        stringList.add("ABC");
        // 下面这句会发生编译错误
        // stringList.add(5);

        for (int i=0; i<stringList.size(); i++) {
            String string = stringList.get(i);
        }
    }
}
