package generics.deep;

/**
 * ClassName: JYKIterator
 * Description: 带泛型的Iterator的实现
 * date: 2019/12/27 22:19
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public interface JYKIterator<E> {
    E next();
    boolean hasNext();

    // ...
}
