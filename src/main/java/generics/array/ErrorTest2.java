package generics.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: 泛型和数组 错误尝试2
 * Description: 使用无上限通配符，需要强转，编译不会发生任何警告
 * date: 2020-01-05 12:13
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class ErrorTest2 {
    public static void main(String[] args) {
        //
        List<?>[] lists = new ArrayList<?>[10];
        Object[] oa = (Object[])lists;

        List<Integer> integerList = new ArrayList<>();
        integerList.add(new Integer(3));
        oa[1] = integerList;
        // 下面代码发生运行时异常
        String s = (String) lists[1].get(0);
    }

    <T> T[] makeArray(Collection<T> coll) {
        // 下面这行代码编译错误，因为类型变量在运行时并不存在，所以编译器无法确定实际类型是什么。
        // return new T[coll.size()];
        return null;
    }
}
