package generics.erasure;

/**
 * ClassName: 泛型擦除示例
 * Description:
 * date: 2020-01-05 11:49
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class ErasureTest {
    public static void main(String[] args) {
        Apple<Integer> a = new Apple<>(6);
        Integer as = a.getSize();
        // 泛型擦除
        Apple b = a;
        Number size1 = b.getSize();

        // 编译错误
        // Integer size2 = b.getSize();
    }
}

class Apple<T extends Number> {
    T size;
    public Apple() {}
    public Apple(T size) {
        this.size = size;
    }

    public T getSize() {
        return size;
    }

    public void setSize(T size) {
        this.size = size;
    }
}
