package clazzLoad_reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ClassName: ProxyTest
 * Description: 使用Proxy和InvocationHandler来生成动态代理对象
 * date: 2019/12/19 22:36
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);

        /*
         *
         */
        p.walk();
        p.sayHallo("Hi JYK");

        System.out.println(p);

        p.test();
    }
}

interface Person {
    void walk();
    void sayHallo(String name);
    void test();
}
