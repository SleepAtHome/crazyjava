package clazzLoad_reflect.proxy.aop;

/**
 * ClassName: DogUtil
 * Description: DogUtil类，包含两个公用方法，拦截器方法
 *
 * 借助Proxy和InvocationHandler就可以实现——当程序调用info()方法和run()方法时，
 * 系统可以"自动"将method1()和method2()两个通用方法插入info()方法和run()方法中执行
 *
 * date: 2019/12/19 22:52
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DogUtil {
    /**
     * 第一个拦截器方法
     */
    public void method1() {
        System.out.println("==模拟第一个通用方法==");
    }

    /**
     * 第二个拦截器方法
     */
    public void method2() {
        System.out.println("==模拟第二个通用方法==");
    }
}
