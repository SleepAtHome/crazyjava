package generics.deep;

/**
 * ClassName: Apple
 * Description: 泛型的使用，类上的泛型声明
 * date: 2019/12/27 22:24
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Apple<T> {
    private T info;

    public Apple() {
    }

    public Apple(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        Apple<String> a1 = new Apple<>("苹果");
        System.out.println(a1.getInfo());

        Apple<Double> a2 = new Apple<>(5.67);
        System.out.println(a2.getInfo());
    }
}
