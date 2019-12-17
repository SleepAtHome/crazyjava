package clazzLoad_reflect.useReflect;
import java.lang.reflect.Array;

/**
 * ClassName: ArrayTest2
 * Description: 使用反射动态擦混构建并操作三维数组
 * date: 2019/12/17 22:33
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        // 创建一个三维数组
        Object arr = Array.newInstance(String.class, 3, 4, 10);
        // 取出来的arrObj是一个二维数组
        Object arrObj = Array.get(arr, 2);
        String[] strings = {"JYK2","HaHa2"};
        Array.set(arrObj, 2, strings);
        // 取出来的anArr是一个一维数组
        Object anArr = Array.get(arrObj, 3);
        Array.set(anArr, 8, "JYK33");

        String[][][] cast = (String[][][]) arr;
        for (String[][] two: cast) {
            for (String[] one: two) {
                for (String s: one) {
                    System.out.print(s+"\t");
                }
                System.out.println("_|_");
            }
            System.out.println("===");
        }
    }
}
