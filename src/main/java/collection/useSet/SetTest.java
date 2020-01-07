package collection.useSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Yuankui Jing
 * @Date: 2020/01/07/16:35
 * @Description: Set集合用法
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> books = new HashSet<>();
        books.add(new String("BOOK1"));
        boolean result = books.add(new String("BOOK1"));
        System.out.println(result+"-->"+books);
    }
}
