package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 对Collection的操作
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();

        // 增加元素
        c.add("景元奎");
        c.add(6); // 会自动装箱
        System.out.println(c.size());

        // 删除指定元素
        c.remove(6);
        System.out.println(c.size());

        // 判断是否包含某个元素
        System.out.println(c.contains("景元奎"));
        c.add("BOOK1");
        System.out.println(c);

        // 判断是否包含某个集合
        Collection books = new HashSet();
        books.add("BOOK1");
        books.add("BOOK2");
        System.out.println(c.containsAll(books));

        // 删除c集合中包含books集合的所有元素
        c.removeAll(books);
        System.out.println(c);

        // 删除集合中所有的元素
        c.clear();
        System.out.println(c);

        // 取交集
        books.retainAll(c);
        System.out.println(books);
    }
}
