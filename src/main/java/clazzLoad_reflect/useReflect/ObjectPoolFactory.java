package clazzLoad_reflect.useReflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ClassName: ObjectPoolFactory
 * Description: 实现一个简单的对象池，该对象池会根据配置文件读取K-V对，
 * 然后创建这些对象，并将这些对象放入一个HashMap中
 *
 * Spring使用了这样的方式
 * date: 2019/12/16 23:26
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ObjectPoolFactory {
    // 定义一个对象池，K-对象名，V-实际对象
    private Map<String, Object> objectPool = new HashMap<>();

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
     * @param fileName 文件名
     */
    public void initPool(String fileName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(fileName)) {
            Properties prop = new Properties();
            prop.load(fis);
            for (String name: prop.stringPropertyNames()) {
                // 放入对象池
                objectPool.put(name, createObject(prop.getProperty(name)));
            }
        } catch (IOException e) {
            System.out.println("读取 "+fileName+" 异常");
            e.printStackTrace();
        }
    }

    /**
     * 从对象池中取出指定name对应的对象
     * @param name
     * @return
     */
    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ObjectPoolFactory opf = new ObjectPoolFactory();
        opf.initPool("jykobj.txt");
        System.out.println(opf.getObject("a"));
        System.out.println(opf.getObject("b"));
    }
}
