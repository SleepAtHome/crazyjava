package clazzLoad_reflect.clazzLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @description: 访问JVM的类加载器
 * @author: Jingyuankui
 * @time: 2019/12/11 18:49
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException {

        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器："+systemLoader);

        /*
        获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定
        if操作系统没有指定CLASSPATH环境变量，则默认以当前路径作为系统类加载器的加载路径
         */
        Enumeration<URL> em1 = systemLoader.getResources("");
        while (em1.hasMoreElements()) {
            System.out.println(em1.nextElement());
        }

        // 系统类加载器的父加载器：扩展类加载器
        ClassLoader extensionLoader = systemLoader.getParent();
        System.out.println("扩展类加载器：" +extensionLoader);
        System.out.println("扩展类加载器的加载路径："+System.getProperty("java.ext.dirs"));

        // 上面两个类加载器都是URLClassLoader的实例

        // 这里得到的是null 但事实上扩展类加载器的父加载器是 根类加载器，但 根类加载器不是Java实现的。
        System.out.println("扩展类加载器的parent："+extensionLoader.getParent());
    }
}
