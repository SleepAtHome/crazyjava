package clazzLoad_reflect.JVM_and_clazz;

/**
 * @description: 验证JVM和类：当Java程序运行结束时，JVM进程结束，改进程在内存中的状态会丢失。
 *
 * 将使用ATest1和ATest2分别运行。（两次运行JVM进程，第一次运行JVM做的修改结束后，对A类做的修改就会丢失）
 * @author: Jingyuankui
 * @time: 2019/12/8 14:25
 */
public class A {
    // 定义该类的静态Field
    public static int aa = 6;
}
