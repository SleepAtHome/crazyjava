package collection.useSet;

import java.util.TreeSet;

/**
 * ClassName: TreeSetTest3
 * Description: 向TreeSet中添加可变类，造成混乱
 * date: 2020-01-09 22:25
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetTest3 {
    public static void main(String[] args) {
        TreeSet<R2> ts = new TreeSet<>();
        ts.add(new R2(5));
        ts.add(new R2(-3));
        ts.add(new R2(9));
        ts.add(new R2(-2));
        System.out.println(ts);

        // 造成元素无序，且有重复元素
        R2 firstR2 = ts.first();
        firstR2.count = 20;
        R2 lastR2 = ts.last();
        lastR2.count = -2;
        System.out.println(ts);

        // 尝试删除重复元素，失败
        System.out.println(ts.remove(new R2(-2)));
        System.out.println(ts);

        // 不过当执行完这行代码以后，TreeSet会对集合中的元素重新索引，接下来就能删除其中的所有元素了。
        System.out.println(ts.remove(new R2(5)));
        System.out.println(ts);

        System.out.println(ts.remove(new R2(-2)));
        System.out.println(ts);
    }
}

class R2 implements Comparable {
    int count;

    public R2(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R2{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj!=null && obj.getClass()==Z.class) {
            R2 r2 = (R2) obj;
            if (r2.count==this.count) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        R2 r2 = (R2) o;
        return count > r2.count ? 1 : count<r2.count?-1:0;
    }
}
