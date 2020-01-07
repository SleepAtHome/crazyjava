package collection.useSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Yuankui Jing
 * @Date: 2020/01/07/20:50
 * @Description: 测试向HashSet中添加一个可变对象，导致HashSet中保存了完全一样的对象。
 */
public class HashSetTest2 {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        System.out.println(hs);

        Iterator it = hs.iterator();
        R first = (R) it.next();
        first.count = 5;
        System.out.println(hs);

        hs.remove(new R(5));
        System.out.println(hs);

        // 造成混乱（原来的5被删掉了，新的5事实上是在-2的位置被存进去的）
        System.out.println("hs.contains 5 ? "+hs.contains(new R(5)));
        System.out.println("hs.contains -2 ? "+hs.contains(new R(-2)));


    }
}
class R {
    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // 如果是同一个对象
        if (this == o) return true;

        // 如果是同一个类
        if (o != null && o.getClass()==R.class) {
            R r = (R) o;

            // 如果他们的count相等，则equals()返回true
            if (r.count==this.count) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}
