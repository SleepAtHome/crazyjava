package generics.method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: 泛型方法的错误尝试
 * Description:为了让编译器能准确地推断出泛型方法中类型形参的类型，不要制造迷惑。
 * date: 2020-01-02 22:11
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class ErrorTest {
    // 从一个Collection拷贝到另一个Collection，这样写是不好的，会让编译器迷惑
    static <T> void test(Collection<T> from, Collection<T> to) {
        for (T ele: from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> lo = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        // 下面代码编译错误，编译器无法识别T所代表的实际类型
        // test(ls, lo);
    }
}
