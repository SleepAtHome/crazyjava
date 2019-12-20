package clazzLoad_reflect.generics.useReflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * ClassName: GenericTest
 * Description:  获取泛型类型
 * date: 2019/12/20 23:35
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class GenericTest {
    private Map<String, Integer> score;

    public static void main(String[] args) throws NoSuchFieldException {
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");
        // 得到Field f 的类型
        Class<?> clazzType = f.getType();
        System.out.println("score的类型是："+clazzType);
        // 得到Field f 的泛型类型
        Type gType = f.getGenericType();
        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type originType = pType.getRawType();
            System.out.println("原始类型是："+originType);
            // 取得泛型类型的泛型参数
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型类型是：");
            for (int i=0; i<tArgs.length; i++) {
                System.out.println("第"+i+"个泛型类型是："+tArgs[i]);
            }
        } else {
            System.out.println("获取泛型类型出错");
        }
    }
}
