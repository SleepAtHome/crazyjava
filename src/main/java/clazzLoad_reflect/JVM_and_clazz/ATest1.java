package clazzLoad_reflect.JVM_and_clazz;

/**
 * @description: 验证JVM和类：当Java程序运行结束时，JVM进程结束，改进程在内存中的状态会丢失。
 * @author: Jingyuankui
 * @time: 2019/12/8 14:26
 */
public class ATest1 {
    public static void main(String[] args) {
        A a = new A();
        // 让a实例的aa Field自增
        a.aa ++;
        System.out.println(a.aa);
    }
}
