package generics.method;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ClassName: TreeSet测试（通配符）
 * Description: 创建一个TreeSet<String>集合，并传入一个可以比较大小的Comparator<String>，也可以是Comparator<Object>
 *     只要尖括号里传入的类型是String本身或其父类即可
 *     TreeMap也有类似用法
 * date: 2020-01-04 12:41
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object first, Object second) {
                return hashCode()>second.hashCode() ? 1 : hashCode()<second.hashCode()? -1 : 0;
            }
        });

        ts1.add("hello!");
        ts1.add("wa");

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()>o2.length()? -1 : o1.length()<o2.length()? 1 : 0;
            }
        });

        ts2.add("Hallo!");
        ts2.add("wa");

        System.out.println(ts1);
        System.out.println(ts2);
    }
}
