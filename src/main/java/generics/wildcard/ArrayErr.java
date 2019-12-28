package generics.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ArrayErr
 * Description: 试图把一个Integer[] 数组赋给一个 Number[] 变量，再将Double对象放到Number[] 中，编译通过，运行出错。
 * date: 2019/12/28 13:04
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ArrayErr {
    public static void main(String[] args) {
        Integer[] ia = new Integer[5];
        Number[] na = ia;
        // 发生java.lang.ArrayStoreException: java.lang.Double异常，因为0.5不是Integer。
        na[0]=0.5;

        List<Integer> integerList = new ArrayList<>();
        // 这个编译会报错
        // List<Number> numberList = integerList;
    }
}
