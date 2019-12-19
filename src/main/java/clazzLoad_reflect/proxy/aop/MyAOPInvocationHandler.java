package clazzLoad_reflect.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ClassName: MyAOPInvocationHandler
 * Description: 我的AOPInvocationHandler，作用是：
 *
 * 借助Proxy和InvocationHandler就可以实现——当程序调用info()方法和run()方法时，
 * 系统可以"自动"将method1()和method2()两个通用方法插入info()方法和run()方法中执行
 *
 * date: 2019/12/19 22:55
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class MyAOPInvocationHandler implements InvocationHandler {

    /**
     * 需要被代理的对象
     */
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 执行动态代理对象的所有方法时，都会被替换成如下的invoke()方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil dogUtil = new DogUtil();
        // 执行DogUtil的method1()方法
        dogUtil.method1();
        // 以target作为主调来执行method方法）—— 执行原本要执行的方法
        Object result = method.invoke(target,args);
        // 执行DogUtil的method2()方法
        dogUtil.method2();
        return result;
    }
}
