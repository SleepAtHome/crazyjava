package generics.method;

/**
 * ClassName: 菱形语法
 * Description: 菱形语法的用法
 * date: 2020-01-04 11:48
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class GenericDiamondTest {
    public static void main(String[] args) {
        // MyClass 中的 E形参 是 String类型；泛型构造器中声明的 T形参 是 Integer类型 （事实上E形参都没有被用到） 使用菱形语法OK
        MyClass<String> mc1 = new MyClass<>(5);

        // 显示指定MyClass中的T是Integer类型 OK
        MyClass<String> mc2 = new <Integer> MyClass<String>(5);

        // 显示指定MyClass中的T是Integer类型  使用菱形语法 不OK
        // MyClass<String> mc3 = new <Integer> MyClass<>(5);
    }
}

class MyClass<E> {
    public <T> MyClass(T t) {
        System.out.println(t);
    }
}
