package generics.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: DiamondTest
 * Description: Java7 菱形语法（构造器后不需要带完整的泛型信息）
 * date: 2019/12/27 22:05
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DiamondTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("JYK");
        stringList.add("ABC");

        for (String s: stringList) {
            System.out.println(s);
        }

        Map<String, List<String>> schoolInfo = new HashMap<>();
        List<String> schools = new ArrayList<>();

        schools.add("schools1");
        schools.add("schools2");
        schools.add("schools3");
        schoolInfo.put("JYK", schools);

        for (String key: schoolInfo.keySet()) {
            List<String> list = schoolInfo.get(key);
            System.out.println(key+"-->"+ list);
        }
    }

}
