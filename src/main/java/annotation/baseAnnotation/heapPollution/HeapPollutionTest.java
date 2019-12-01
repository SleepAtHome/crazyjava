package annotation.baseAnnotation.heapPollution;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HeapPollutionTest
 * Description: 测试"堆污染"的情况1，当把一个不带泛型的对象赋值给一个带范型的变量时，就会发生"堆污染"。
 * date: 2019/12/1 23:37
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class HeapPollutionTest {
    public static void main(String[] args) {
        // 创建一个List，声明不带泛型
        List list = new ArrayList<Integer>();
        // 添加元素时引发unchecked异常?
        list.add(20);
        // 下面代码引起"未经检查的转换"警告；但编译、运行时完全正常；堆污染
        List<String> strList = list;
        // 但是只要访问strList的元素，下面代码，就会引起运行时异常：
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        System.out.println(strList.get(0));
    }
}
