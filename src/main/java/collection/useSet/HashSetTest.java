package collection.useSet;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Yuankui Jing
 * @Date: 2020/01/07/19:42
 * @Description: 测试HashSet
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();

        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());

        System.out.println(books.size());
        System.out.println(books);
    }
}

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class B {
    @Override
    public int hashCode() {
        return 1;
    }
}

class C {
    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
