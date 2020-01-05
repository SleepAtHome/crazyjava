package generics.erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: 泛型擦除示例2
 * Description: 尝试List泛型的使用（擦除）
 * date: 2020-01-05 11:54
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class ErasureTest2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(9);
        // 泛型擦除
        List list2 = list;
        // 编译正常（会有"未经检查的转换"警告）
        List<String> ls = list2;
        // 运行错误
        System.out.println(ls.get(0));


        /*
        下面代码也会有运行时异常，与上面例子类似
         */
        List li = new ArrayList();
        li.add(7);
        li.add(8);
        System.out.println((String)li.get(0));
    }
}
