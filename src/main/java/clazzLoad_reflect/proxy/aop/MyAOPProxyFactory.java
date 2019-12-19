package clazzLoad_reflect.proxy.aop;

import java.lang.reflect.Proxy;

/**
 * ClassName: MyAOPProxyFactory
 * Description: 专门为指定的target生成动态代理实例
 * date: 2019/12/19 23:02
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class MyAOPProxyFactory {
    /**
     * 为指定的对象o生成动态代理对象
     * @param o 想被生成动态代理的对象
     * @return
     */
    public static Object getProxy(Object o) {
        MyAOPInvocationHandler handler = new MyAOPInvocationHandler();
        // 设置对象
        handler.setTarget(o);
        // 创建并返回一个动态代理
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), handler);
    }
}
