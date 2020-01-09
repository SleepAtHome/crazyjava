package collection.useSet;

import java.util.TreeSet;

/**
 * ClassName: TreeSetErrorTest
 * Description: 将未实现Comparable接口的对象传入到TreeSet中，出现异常
 * date: 2020-01-09 22:00
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class TreeSetErrorTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        // 这一步不会有异常，因为ts中没有任何元素（但取出这个元素的时候也会发生异常）
        ts.add(new Err());
        // 这一步出现ClassCastException异常，因为Err没有实现Comparable
        ts.add(new Err());
    }
}

class Err {}
