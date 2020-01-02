package generics.method;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: 我的Collection
 * Description: 泛型方法和类型通配符的区别——2.使用泛型方法包装Collection
 * T的作用是可以在不同的调用点传入不同的实际类型。
 * 对于这种情况，应该使用通配符，通配符就是被设计用来支持灵活的子类化的。
 * date: 2020-01-03 00:06
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public interface JYKCollection2<E> {
    <T> boolean contailnsAll(Collection<T> c);
    <T extends E> boolean addAll(Collection<T> c);
    // ...
}
