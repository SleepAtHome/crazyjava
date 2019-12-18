package clazzLoad_reflect.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @description: 生成一个动态代理类，
 * 通过这个动态代理类来创建代理对象的方式生成一个动态代理对象。
 *
 * @author: Jingyuankui
 * @time: 2019/12/18 11:38
 */
public class JYKProxy1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InvocationHandler ih = new MyInvocationHandler();
        // 使用Proxy生成一个动态代理类proxyClazz
        Class proxyClazz = Proxy.getProxyClass(Foo.class.getClassLoader(), new Class[] {Foo.class});
        // 获取proxyClazz类中带一个InvocationHandler参数的构造器
        Constructor con = proxyClazz.getConstructor(new Class[] {InvocationHandler.class});
        // 调用con的newInstance方法类创建动态实例
        Foo f = (Foo) con.newInstance(new Object[] {ih});

        System.out.println(f);
    }
}
