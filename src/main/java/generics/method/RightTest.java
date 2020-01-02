package generics.method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: 泛型方法的正确尝试
 * Description:为了让编译器能准确地推断出泛型方法中类型形参的类型，不要制造迷惑。
 * date: 2020-01-02 22:11
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class RightTest {
    // 从一个Collection拷贝到另一个Collection，这样写是不好的，会让编译器迷惑
    static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (T ele: from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> lo = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        // 下面代码编译正确
        test(ls, lo);
    }
}
