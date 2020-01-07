package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Iterator迭代时改变元素，导致异常例子
 * 发生ConcurrentModificationException
 */
public class IteratorErrorTest {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("BOOK1");
        books.add("BOOK2");
        books.add("BOOK3");

        Iterator it = books.iterator();
        while (it.hasNext()) {
            String book = (String) it.next();
            System.out.println(book);

            if (book.equals("BOOK2")) {
                books.remove(book);
            }
        }
    }
}
