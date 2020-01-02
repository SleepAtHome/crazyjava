package generics.method;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: 泛型方法
 * Description: 泛型方法的用法
 * date: 2020-01-02 21:54
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class GenericMethodTest {
    /**
     * 声明一个泛型方法，该泛型方法中带一个T类型的形参
     * 把数组元素放入集合中
     * @param a
     * @param c
     * @param <T>
     */
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T t: a) {
            c.add(t);
        }
    }

    public static void main(String[] args) {
        // 把Object数组元素放入Object集合中
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        fromArrayToCollection(oa, co);

        // 把String数组元素放入String集合中
        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa, cs);

        // 把String数组元素放入Object集合中-T为Object类型
        fromArrayToCollection(sa, co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];

        Collection<Number> cn = new ArrayList<>();

        // 把Integer数组元素放入Number集合中-T为Number类型
        fromArrayToCollection(ia, cn);
        // 把Integer数组元素放入Number集合中-T为Number类型
        fromArrayToCollection(fa, cn);
        // 把Number数组元素放入Number集合中-T为Number类型
        fromArrayToCollection(na, cn);
        // 把Number数组元素放入Object集合中-T为Object类型
        fromArrayToCollection(na, co);

        // 下面代码编译出错，因为Number既不是String类型，也不是它的子类
        // fromArrayToCollection(na, cs);
    }


}
