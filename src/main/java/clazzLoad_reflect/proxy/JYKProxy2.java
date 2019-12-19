package clazzLoad_reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ClassName: JYKProxy2
 * Description:生成一个动态代理类2（效果等同JYKProxy1）
 * 通过这个动态代理类来创建代理对象的方式生成一个动态代理对象。
 *
 * 为什么这里的f是null？toString方法是怎么调用的？
 *
 * date: 2019/12/19 22:31
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class JYKProxy2 {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, handler);
        System.out.println(f);
    }


}
