package generics.method;

/**
 * ClassName: 泛型构造器
 * Description:
 * date: 2020-01-04 11:42
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class GenericConstructor {
    public static void main(String[] args) {
        new Foo("JYK");
        new Foo(100);
        new <String> Foo("JYK2");
        // 下面代码编译错误，因为泛型为String对象
        // new <String> Foo(123);
    }
}

class Foo {
    public <T> Foo(T t) {
        System.out.println(t);
    }
}
