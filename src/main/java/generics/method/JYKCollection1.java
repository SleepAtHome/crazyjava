package generics.method;

import java.util.Collection;

/**
 * ClassName: 我的Collection
 * Description: 泛型方法和类型通配符的区别——1.使用类型通配符包装Collection
 * date: 2020-01-03 00:06
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public interface JYKCollection1<E> {
    boolean contailnsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    // ...
}
