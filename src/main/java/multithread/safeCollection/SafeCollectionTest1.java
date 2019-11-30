package multithread.safeCollection;

import java.util.*;

/**
 * ClassName: SafeCollectionTest1
 * Description: 通过Collections提供的静态方法，得到安全的集合类
 * date: 2019/11/30 20:31
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class SafeCollectionTest1 {
    public static void main(String[] args) {
        Map<Object, Object> hashMap= Collections.synchronizedMap(new HashMap<>());
        List<Object> arrayList = Collections.synchronizedList(new ArrayList<>());
    }
}
