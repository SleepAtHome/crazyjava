package clazzLoad_reflect.clazzLoader;

import java.net.URL;

/**
 * @description: 获得根类加载器的核心类库
 * @author: Jingyuankui
 * @time: 2019/12/8 17:26
 */
public class BootstrapTest {
    public static void main(String[] args) {

        // 获取根类加载器所加载的全部URL数组
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        // 遍历、输出根类加载器所加载的全部URL
        for (int i=0; i<urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}
