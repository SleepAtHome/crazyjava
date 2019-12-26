package generics.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CheckType
 * Description: 实现一个List对象，只能保存String类型（不使用泛型），编译时的异常检查
 * 包装List类进行实现
 * date: 2019/12/26 23:50
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class CheckType {
    public static void main(String[] args) {
        StrList strlist = new StrList();
        strlist.add("JYK");
        strlist.add("ABC");
        // 这里就会编译错误
        // strlist.add(1);

        for (int i=0; i<strlist.size(); i++) {
            // 无需强转，因为得到的就是String类型
            String string = strlist.get(i);
        }
    }
}

/**
 * 自定义的StrList类，是一个只能存String类型的List
 */
class StrList {
    private List strList = new ArrayList();

    /**
     * 对add方法进行包装，对外只能传入String类型
     * @param s
     * @return
     */
    public boolean add(String s) {
        return strList.add(s);
    }

    /**
     * 对get方法进行包装，对外只能得到String
     * @param index
     * @return
     */
    public String get(int index) {
        return (String) strList.get(index);
    }

    public int size() {
        return strList.size();
    }
}
