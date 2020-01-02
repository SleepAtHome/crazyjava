package generics.method;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: 我的Collection
 * Description: 泛型方法和类型通配符的区别——3.都使用
 * date: 2020-01-03 00:06
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public interface JYKCollection3<E> {

    // Collections.copy方法，同时使用泛型方法和通配符也是可以的
    public static <T> void copy(List<T> dest, List<? extends T> src) {}

    // Collections.copy方法也可以不使用通配符（但使用通配符更明确）
    public static <T, S extends T> void copy2(List<T> dest, List<S> src) {}
}
