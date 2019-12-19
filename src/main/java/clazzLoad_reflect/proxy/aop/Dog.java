package clazzLoad_reflect.proxy.aop;

/**
 * ClassName: Dog
 * Description: Dog接口，测试动态代理和AOP的作用
 * 使用Proxy为Dog接口创建动态代理对象
 * date: 2019/12/19 22:49
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public interface Dog {
    /**
     * info方法声明
     */
    void info();

    /**
     * run方法声明
     */
    void run();
}
