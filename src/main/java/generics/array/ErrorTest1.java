package generics.array;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: 泛型和数组 错误尝试1
 * Description:
 * date: 2020-01-05 12:13
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class ErrorTest1 {
    public static void main(String[] args) {
        // 发生便已经改
        List<String>[] stringList = new ArrayList[10];
        Object[] oa = (Object[])stringList;

        List<Integer> integerList = new ArrayList<>();
        integerList.add(new Integer(3));
        oa[1] = integerList;
        // 下面代码发生运行时异常
        String s = stringList[1].get(0);
    }
}
