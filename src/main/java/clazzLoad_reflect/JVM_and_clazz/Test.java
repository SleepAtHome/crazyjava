package clazzLoad_reflect.JVM_and_clazz;

/**
 * @description: 验证类的初始化（静态变量的初始化）
 * @author: Jingyuankui
 * @time: 2019/12/8 15:48
 */
public class Test {

    // 声明a变量时指定初始值。
    static int a = 5;
    static int b;

    // 没有指定初始值，默认为0
    static int c;

    static {
        // 使用静态初始化块为b变量指定初始值
        b = 6;
        System.out.println("使用静态初始化块为b变量指定初始值");
    }

    public static void main(String[] args) {
        System.out.println(Test.b);
    }
}
