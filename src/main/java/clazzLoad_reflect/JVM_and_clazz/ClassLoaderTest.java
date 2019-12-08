package clazzLoad_reflect.JVM_and_clazz;

/**
 * @description: 使用ClassLoader类的loadClass()方法来加载某个类时，不会执行该类的初始化。
 *
 * 使用ClassLoader类的loadClass()方法来加载某个类时，该方法只是加载该类，并不会执行该类的初始化。
 * 使用Class的forName()静态方法才会导致强制初始化该类。
 *
 * @author: Jingyuankui
 * @time: 2019/12/8 16:34
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // 要带包名
        classLoader.loadClass("clazzLoad_reflect.JVM_and_clazz.Tester");

        System.out.println("===系统加载Tester类===");
        // 要带包名
        Class.forName("clazzLoad_reflect.JVM_and_clazz.Tester");
    }
}

class Tester {
    static {
        System.out.println("Tester的static初始化块...");
    }
}
