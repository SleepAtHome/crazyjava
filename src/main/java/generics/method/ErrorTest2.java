package generics.method;

import java.util.Collection;

/**
 * ClassName: 泛型方法与方法重载的尝试
 * Description:
 * date: 2020-01-05 11:38
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class ErrorTest2 {

}

class ErrorTest2Utils {
    // 这两种方法不能算重载，算重复了
    public static <T> void copy(Collection<T> dest, Collection<? extends T> src) {}
    // public static <T> T copy(Collection<? super T> dest, Collection<T> src) {}
}
