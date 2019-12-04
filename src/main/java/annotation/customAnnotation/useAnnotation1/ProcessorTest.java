package annotation.customAnnotation.useAnnotation1;

import java.lang.reflect.Method;

/**
 * ClassName: ProcessorTest
 * Description: 使用反射的方法，去调用使用@Testable注解的方法，并运行，进行测试。
 * date: 2019/12/4 23:51
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ProcessorTest {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;

        // 遍历clazz对应的类中所有的方法
        for (Method m: Class.forName(clazz).getMethods()) {
            // 如果该方法使用了@Testable修饰
            if (m.isAnnotationPresent(Testable.class)) {
                try {
                    // 调用m方法
                    m.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.out.println("方法"+m+"运行失败，异常："+e.getCause());
                    failed++;
                    System.out.println("==========================================");
                    e.printStackTrace();
                }
            }
        }
        // 统计测试结果
        System.out.println("共运行了："+(passed+failed)+"个方法，其中：\t"+failed+"个失败了\t"+passed+"个成功了！");
    }
}
