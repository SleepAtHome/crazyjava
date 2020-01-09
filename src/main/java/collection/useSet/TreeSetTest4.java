package collection.useSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ClassName: TreeSetTest4
 * Description: TreeSet定制排序，比如实现从大到小
 * date: 2020-01-09 22:47
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetTest4 {
    public static void main(String[] args) {
        TreeSet<M> ts = new TreeSet<>(new Comparator<M>() {
            @Override
            public int compare(M o1, M o2) {
                M m1 = o1;
                M m2 = o2;
                return m1.age > m2.age ? -1 : m1.age<m2.age?1:0;
            }
        });

        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        System.out.println(ts);
    }
}

class M {
    int age;

    public M(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "M{" +
                "age=" + age +
                '}';
    }
}
