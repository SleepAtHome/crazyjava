package collection.useSet;

import java.util.LinkedHashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Yuankui Jing
 * @Date: 2020/01/07/21:18
 * @Description: LinkedHashSet用法
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> books = new LinkedHashSet<>();
        books.add("BOOK1");
        books.add("BOOK2");
        books.add("BOOK3");
        System.out.println(books);
        books.remove("BOOK1");
        books.add("BOOK1");
        System.out.println(books);
    }
}
