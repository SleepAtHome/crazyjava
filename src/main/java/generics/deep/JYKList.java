package generics.deep;

import java.util.Iterator;

/**
 * ClassName: JYKList
 * Description: 带泛型的List
 * 定义接口时指定了一个类型形参，该形参名为E
 * date: 2019/12/27 22:15
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public interface JYKList<E> {
    /**
     * E可以作为类型使用，可以作为参数类型
     * @param e
     */
    void add(E e);
    Iterator<E> iterator();

    // ...等等
}
