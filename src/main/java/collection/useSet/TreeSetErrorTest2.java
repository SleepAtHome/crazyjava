package collection.useSet;

import java.util.Date;
import java.util.TreeSet;

/**
 * ClassName:TreeSetErrorTest2
 * Description: 往TreeSet集合中添加不同类的对象（compareTo()方法会进行强转，所以会报错），导致发生ClassCastException异常
 * date: 2020-01-09 22:04
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetErrorTest2 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new StringBuffer("AAA"));
        ts.add(new Date());
    }
}
