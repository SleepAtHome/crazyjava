package generics.method;

import java.util.*;
import java.util.concurrent.TransferQueue;

/**
 * ClassName: 我的工具类（把一个集合拷贝到另一个集合中，使用通配符的下限）
 * Description: 把src的集合里的元素拷贝到dest中
 * date: 2020-01-04 12:22
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class MyUtils {
    // dest集合的元素类型必须与src集合的元素类型相同，或者是其父类
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T ele: src) {
            last = ele;
            dest.add(ele);
        }

        return last;
    }

    public static void main(String[] args) {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        li.add(5);

        // 把List<Integer>集合中的元素放到List<Number>中，但是能准确地知道元素的具体类型（而不是他们的父类）
        Integer last = copy(ln, li);
        System.out.println(last);


    }
}
