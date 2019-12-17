package clazzLoad_reflect.useReflect;

import java.lang.reflect.Array;

/**
 * ClassName: ArrayTest1
 * Description: 使用反射动态擦混构建并操作数组
 * date: 2019/12/17 22:25
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        // 使用反射创建一个长度为10的数组
        Object arr = Array.newInstance(String.class, 10);
        // 往数组设置值
        Array.set(arr, 5, "JYK");
        Array.set(arr, 6, "HaHa");
        // 取出arr数组中index为5、6的值
        Object jyk1 = Array.get(arr, 5);
        Object jyk2 = Array.get(arr, 6);

        System.out.println(jyk1);
        System.out.println(jyk2);

        System.out.println(arr);
        for (int i=0; i<10; i++) {
            System.out.print(Array.get(arr, i)+"\t");
        }
    }
}
