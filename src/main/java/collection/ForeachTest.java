package collection;

import java.util.Collection;
import java.util.HashSet;

/**
 * foreach用法，迭代时也不能改动集合中的元素
 */
public class ForeachTest {
    public static void main(String[] args) {
        Collection<String> books = new HashSet<>();
        books.add(new String("BOOK1"));
        books.add(new String("BOOK2"));
        books.add(new String("BOOK3"));

        for (String book: books) {
            System.out.println(book);
            if (book.equals("BOOK2")) {
                System.out.println("hahah");
            }
        }

        System.out.println(books);
    }
}
