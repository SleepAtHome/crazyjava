package generics.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Test
 * Description: 测试类型通配符
 * 定义一个方法，方法里有一个集合形参，集合形参的元素类型是不确定的
 * date: 2019/12/28 12:56
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class TestErr {

    /**
     * 尝试使用Object（但这样是不对的）, 在使用这个方法的时候就会出现问题，例如我想使用test(List<String> strList)的时候
     * @param objects
     */
    public static void test(List<Object> objects) {
        for (int i=0; i<objects.size(); i++) {
            System.out.println(objects.get(i));
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        // 编译会报错: List<String>对象不能被当成List<Object>对象使用。
        // test(stringList);

        // 不能这样使用，在add 的时候会编译报错。
        List<?> c = new ArrayList<>();
        // c.add(new Object());
    }


}
