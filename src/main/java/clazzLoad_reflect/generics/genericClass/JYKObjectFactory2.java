package clazzLoad_reflect.generics.genericClass;

/**
 * @description: 对象工厂2，可以根据指定类来提供该类的实例
 *
 * 这样写的话，用的时候不需要用括号进行强转。更为安全一些
 *
 * @author: Jingyuankui
 * @time: 2019/12/20 14:52
 */
public class JYKObjectFactory2 {
    /**
     *  得到一个实例
     *  Class<T> ：一个泛型化的Class对象（String.Class等）
     */
    public static <T> T getInstance(Class<T> clsName) {
        try {
            return clsName.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
