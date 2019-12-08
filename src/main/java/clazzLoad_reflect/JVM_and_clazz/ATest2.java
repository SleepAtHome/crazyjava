package clazzLoad_reflect.JVM_and_clazz;

/**
 * @description: 验证JVM和类：当Java程序运行结束时，JVM进程结束，改进程在内存中的状态会丢失。
 * @author: Jingyuankui
 * @time: 2019/12/8 14:28
 */
public class ATest2 {
    public static void main(String[] args) {
        A b = new A();
        System.out.println(b.aa);
    }
}
