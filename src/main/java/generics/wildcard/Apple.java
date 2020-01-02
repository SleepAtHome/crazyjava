package generics.wildcard;

/**
 * ClassName: 苹果类
 * Description:用于测试类型形参的上限
 * date: 2020-01-02 21:35
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class Apple<T extends Number> {
    T col;

    public static void main(String[] args) {
        Apple<Integer> ai = new Apple<>();
        Apple<Double> ad = new Apple<>();

        // 下面代码编译出错，因为String不是Number的子类
        // Apple<String> as = new Apple<>();
    }
}
