package array;

import java.util.Arrays;

/**
 * 测试数组的工具类
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 6};
        int[] a2 = new int[]{3, 4, 5, 6};

        // 判断数组a和a2是否相等(长度&元素都相等)
        System.out.println(Arrays.equals(a,a2));

        int[] b = Arrays.copyOf(a, 6);
        System.out.println(Arrays.equals(a, b));
        System.out.println("Array b : "+Arrays.toString(b));

        Arrays.fill(b, 2, 4, 1);
        System.out.println("Array b : "+Arrays.toString(b));

        Arrays.sort(b);
        System.out.println("Array b : "+Arrays.toString(b));

    }
}
