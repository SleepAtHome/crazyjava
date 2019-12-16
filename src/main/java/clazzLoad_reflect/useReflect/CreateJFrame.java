package clazzLoad_reflect.useReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: CreateJFrame
 * Description: 利用反射创建一个JFrame对象，使用指定构造器
 * date: 2019/12/16 23:46
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class CreateJFrame {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        Constructor constructor = jframeClazz.getConstructor(String.class);
        Object obj = constructor.newInstance("测试窗口");
        System.out.println(obj);
    }
}
