package clazzLoad_reflect.check_information_by_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: JYKTestGetMethod
 * Description:测试传入参数Class<?>的作用
 * date: 2019/12/15 15:50
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class JYKTestGetMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class aClazz = A.class;
        // 通过传入参数分辨重写的方法
        Method method1 = aClazz.getMethod("info", String.class);
        Method method2 = aClazz.getMethod("info", String.class, Integer.class);
        //method1.invoke(new A(), null);
        System.out.println(method1);
        System.out.println(method2);
    }
}

class A {
    public void info(){
        System.out.println("没有参数的info");
    }

    public void info(String str) {
        System.out.println("有1个String参数的info");
    }

    public void info(String str, Integer num) {
        System.out.println("有2个参数的info，分别是String和Integer");
    }
}
