package collection.useSet;

import java.util.TreeSet;

/**
 * ClassName: TreeSetTest2
 * Description: 测试TreeSet加入的对象自己实现Comparable接口，永远返回不一样，这样就能将两个同样的对象插入TreeSet中。（这样不好）
 * date: 2020-01-09 22:16
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        TreeSet<Z> ts = new TreeSet<>();
        Z z1 = new Z(6);
        ts.add(z1);
        System.out.println(ts.add(z1));
        System.out.println(ts);
        for (Z i: ts) {
            System.out.print(i.age);
        }
        System.out.println("---");

        ts.first().age = 9;
        System.out.println(ts.last().age);
        System.out.println(ts);
        for (Z i: ts) {
            System.out.print(i.age);
        }
    }
}

class Z implements Comparable {
    int age;

    public Z(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
