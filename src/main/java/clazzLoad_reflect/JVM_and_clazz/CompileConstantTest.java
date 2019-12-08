package clazzLoad_reflect.JVM_and_clazz;

/**
 * @description: 特别指出：对于一个final型的静态Field，即使程序使用该静态Field，也不会导致该类的初始化。
 * 这个Field相当于"宏变量"，Java编译器会在编译时直接把这个Field出现的地方替换成它的值。
 *
 * 编译时确定下来的final型的静态Field，就相当于常量。
 *
 * @author: Jingyuankui
 * @time: 2019/12/8 16:22
 */
public class CompileConstantTest {
    public static void main(String[] args) {
        // 访问、输出 JYKTest中 编译时可确定的 final型的静态Field（不会初始化JYKTest类）
        System.out.println(JYKTest.compileConstant);

        System.out.println("=======");

        // 访问、输出 JYKTest中 编译时不可确定的 final型的静态Field（会初始化JYKTest类）
        System.out.println(JYKTest.compileConstantTime);
    }
}

class JYKTest {
    static {
        System.out.println("JYKTest的static初始化块...");
    }
    // final型的静态Field
    static final String compileConstant = "景元奎";

    // 这个compileConstantTime需要运行时才能确定，所以使用时会初始化该类
    static final String compileConstantTime = System.currentTimeMillis()+"";
}
