package clazzLoad_reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 执行动态代理对象的所有方法时，都会被替换成以下的invoke方法
 *
 * @author: Jingyuankui
 * @time: 2019/12/18 13:04
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     *
     * @param proxy 动态代理对象
     * @param method 正在执行的方法
     * @param args 调用目标方法时传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------正在执行的方法"+method);
        if (args != null) {
            System.out.print("执行该方法时传入的实参： ");
            for (Object val: args) {
                System.out.print(val+"\t");
            }
            System.out.println();
        } else {
            System.out.println("调用该方法没有实参！");
        }
        return null;
    }
}
