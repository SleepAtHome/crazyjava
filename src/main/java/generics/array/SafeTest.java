package generics.array;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:泛型和数组 安全尝试1
 * Description:
 * date: 2020-01-05 12:56
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class SafeTest {
    public static void main(String[] args) {
        List<?>[] lists = new ArrayList<?>[10];
        Object[] oa = (Object[])lists;

        List<Integer> integerList = new ArrayList<>();
        integerList.add(new Integer(3));
        oa[1] = integerList;

        // 这样做的话就安全了
        Object target = lists[1].get(0);
        if (target instanceof String) {
            String s = (String) lists[1].get(0);
        }

    }
}
