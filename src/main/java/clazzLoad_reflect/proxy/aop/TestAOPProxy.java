package clazzLoad_reflect.proxy.aop;

/**
 * ClassName: TestAOPProxy
 * Description: 测试使用动态代理实现AOP
 * date: 2019/12/19 23:08
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class TestAOPProxy {
    public static void main(String[] args) {
        Dog gundog = new GunDog();
        Dog proxyDog = (Dog) MyAOPProxyFactory.getProxy(gundog);
        // 使用proxyDog去执行方法（invoke()）
        proxyDog.info();
        proxyDog.run();
    }
}
