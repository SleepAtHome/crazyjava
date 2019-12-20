package clazzLoad_reflect.generics.genericClass;

/**
 * @description: 对象工厂，可以根据指定类来提供该类的实例
 *
 * 这样写的话，用的时候需要用括号进行强转。
 *
 * @author: Jingyuankui
 * @time: 2019/12/20 14:52
 */
public class JYKObjectFactory1 {
    public static Object getInstance(String clsName) {
        try {
            Class clazz = Class.forName(clsName);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
