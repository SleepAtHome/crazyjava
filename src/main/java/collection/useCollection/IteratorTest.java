package collection.useCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator的用法
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection books = new ArrayList();
        books.add("BOOK1");
        books.add("BOOK2");
        books.add("BOOK3");

        // 通过集合获取迭代器
        Iterator it = books.iterator();

        // 当集合中有下一个元素的时候
        while (it.hasNext()) {
            // it.next() 指向集合中的下一个元素，并且返回当前元素
            String book = (String) it.next();
            System.out.println(book);

            if (book.equals("BOOK2")) {
                // remoe掉刚才.next()返回的那个元素
                it.remove();
            }
        }

        System.out.println(books);
    }
}
