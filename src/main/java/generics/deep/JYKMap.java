package generics.deep;

import java.util.Set;

/**
 * ClassName: JYKMap
 * Description: 带泛型的Map的实现
 * date: 2019/12/27 22:20
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public interface JYKMap<K, V> {
    /**
     * 在这个接口里K、V完全可以作为类型使用
     * @return
     */
    Set<K> keySet();
    V put(K key, V value);
}
