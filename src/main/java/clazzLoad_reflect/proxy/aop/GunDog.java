package clazzLoad_reflect.proxy.aop;

/**
 * ClassName: GunDog
 * Description: 实现了Dog接口的类
 * date: 2019/12/19 22:51
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class GunDog implements Dog{
    @Override
    public void info() {
        System.out.println("我是一只猎狗");
    }

    @Override
    public void run() {
        System.out.println("我是GunDog，我奔跑迅速");
    }
}
