package clazzLoad_reflect.generics.genericClass;

import java.lang.reflect.Array;

/**
 * @description: 使用泛型对Array的newInstance()方法进行包装。
 * @author: Jingyuankui
 * @time: 2019/12/20 15:13
 */
public class JYKArray {
    /**
     * 对Array的newInstance()方法进行包装。
     * @param componentType
     * @param length
     * @param <T>
     * @return
     */
    @SuppressWarnings(value = "unchecked")
    public static <T> T[] newInstance(Class<T> componentType, int length) {
        return (T[]) Array.newInstance(componentType, length);
    }

    public static void main(String[] args) {
        // 创建一维数组
        String[] strings = JYKArray.newInstance(String.class, 10);
        // 创建二维数组
        int[][] ints = JYKArray.newInstance(int[].class, 5);

        strings[5] = "JYK";
        ints[1] = new int[]{23, 12};
        for (String s: strings) {
            System.out.print(s+"\t");
        }
        System.out.println();
        // 这里的数组只有一个被初始化了
        System.out.println(ints[1][1]);
        // 所以下面的报错
        for (int[] i1: ints) {
            for (int i2: i1) {
                System.out.print(i2+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
