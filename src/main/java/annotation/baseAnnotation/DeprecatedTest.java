package annotation.baseAnnotation;

/**
 * ClassName: DeprecatedTest
 * Description: @Deprecated注解用法，标示（类、方法）已过时
 * date: 2019/12/1 10:24
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DeprecatedTest {
    public static void main(String[] args) {
        // 使用已过时的方法会被编译器警告（IDE会画删除线）
        new Pear().info();
    }
}

class Pear {
    /**
     * 定义info方法已过时
     */
    @Deprecated
    public void info() {
        System.out.println("Pear的info方法...");
    }
}
