package generics.deep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: R
 * Description:
 * date: 2019/12/27 23:00
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class R<T> {
    // 错的，不能在静态Field中声明使用类型形参
    //static T info;

    T age;
    public void foo(T msg) { }

    // 错的，不能在静态方法中声明使用类型形参
    // public static void bar(T msg) { }


    public static void main(String[] args) {
        Collection cs = new ArrayList<String>();
        // 错的，不能在instanceof运算符后使用泛型类。
        // if (cs instanceof List<String>) { }
    }
}
