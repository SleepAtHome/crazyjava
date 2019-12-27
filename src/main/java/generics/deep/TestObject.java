package generics.deep;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: TestObject
 * Description: 验证加了两个加了泛型的对象的Class是否相等。
 * date: 2019/12/27 22:56
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class TestObject {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        // true
        System.out.println(l1.getClass() == l2.getClass());
    }
}
