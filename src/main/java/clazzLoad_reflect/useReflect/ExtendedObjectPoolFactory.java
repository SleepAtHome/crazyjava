package clazzLoad_reflect.useReflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description: 加强的对象池工厂
 * 允许在配置文件中增加配置对象的属性值，对象池工厂会读取该对象的属性值
 * 并利用该对象对应的setter方法为对应属性设置值。
 *
 * 配置文件格式为：
 * 对象名=全限定类名
 * e.g. a=java.util.Date
 *
 * Spring框架就是通过这种将Field值以及依赖对象等都放在配置文件中进行管理，实现了较好的解耦（IOC的秘密）
 *
 * @author: Jingyuankui
 * @time: 2019/12/17 12:02
 */
public class ExtendedObjectPoolFactory {
    private Map<String, Object> objectPool = new HashMap<>();
    private Properties config = new Properties();

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ExtendedObjectPoolFactory eopf = new ExtendedObjectPoolFactory();
        eopf.init("jykeopf.txt");
        eopf.initPool();
        eopf.initProperty();
        System.out.println(eopf.getObject("a"));
    }


    /**
     * 从指定属性文件中初始化Properties对象
     * @param fileName
     */
    public void init(String fileName) {
        try(FileInputStream fis = new FileInputStream(fileName)) {
            config.load(fis);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建对象的方法，可以根据传入的clazzName生成对应的Java对象
     * @param clazzName 字符串类名
     * @return
     */
    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }

    /**
     * 根据指定文件来初始化对象池
     */
    public void initPool() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (String name: config.stringPropertyNames()) {
            // 在一个K-V对中，如果K中不包含%，那就表明用这个V来创建一个对象。
            if (!name.contains("%")) {
                objectPool.put(name, createObject(config.getProperty(name)));
            }
        }
    }


    /**
     * 根据配置文件中的内容来创建对象
     */
    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String name: config.stringPropertyNames()) {
            // 在一个K-V对中，如果K中包含%，那就表明这个Key是用来为对象的Field赋值。
            // %前半段为对象名字，后半段为Field名，调用对应的setter方法为对应的Field赋值
            if (name.contains("%")) {
                // 将配置的Key按%进行分割
                String[] objAndProp = name.split("%");
                // 从对象池中取出对应的对象
                Object target = getObject(objAndProp[0]);
                // 获取setter的方法名（Field的首字母大写）,一会用这个名字获取method
                String methodName = "set"+objAndProp[1].substring(0,1).toUpperCase()+objAndProp[1].substring(1);
                // 获取这个对象对应的Class对象
                Class<?> targetClazz = target.getClass();
                // 获取该属性对应的Setter方法
                Method mtd = targetClazz.getMethod(methodName, String.class);
                // 方法的调用，配置的Value作为setter的实参
                mtd.invoke(target, config.getProperty(name));
            }
        }
    }

    /**
     * 从对象池中取出指定name对应的对象
     * @param name 对象名、名字
     * @return
     */
    public Object getObject(String name) {
        return objectPool.get(name);
    }
}
