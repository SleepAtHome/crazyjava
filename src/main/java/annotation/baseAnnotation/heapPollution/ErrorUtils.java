package annotation.baseAnnotation.heapPollution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: ErrorUtils
 * Description: 测试"堆污染"的情况2，参数可变的方法，该形参类型又是泛型，更容易导致"堆污染"
 * date: 2019/12/1 23:47
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ErrorUtils {
    public static void faultyMethod(List<String>... lists) {
        /*
        Java不允许创建泛型数组，因此listsArray只能被当成List[]处理
        此时相当于把List<String>赋给了List，已经发生了"堆污染"
         */
        List[] listsArray = lists;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(new Random().nextInt(100));
        listsArray[0] = integerList;
        String s = lists[0].get(0);
    }
}
