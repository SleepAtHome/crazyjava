package generics.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Test
 * Description: 正确使用类型通配符
 * 有List<?>、Set<?>、Collection<?>、Map<?, ?>等
 * date: 2019/12/28 13:18
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class TestRight {
    /**
     * 使用类型通配符：?
     * @param list
     */
    public static void test(List<?> list) {
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    public static void main(String[] args) {
        // 可以正常调用
        List<String> stringList = new ArrayList<>();
        test(stringList);

        List<Integer> integerList = new ArrayList<>();
        test(integerList);
    }
}
