package annotation.metaAnnotation;

/**
 * ClassName: Mytest
 * Description: 进行@Documented的使用
 * date: 2019/12/3 0:29
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Mytest {

    /**
     * @Testable 使用了@Documented，在生成javadoc的时候，info()方法上会显示@Testable注解。
     * @Testable 不使用@Documented，在生成javadoc的时候，info()方法上就不会会显示@Testable注解。
     * 使用javadoc命令的时候，要把Mytest和Testable都生成出来，才有
     */
    @Testable
    public void info() {
        System.out.println("info方法...");
    }
}
