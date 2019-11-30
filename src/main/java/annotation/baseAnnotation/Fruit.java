package annotation.baseAnnotation;

/**
 * ClassName: Fruit
 * Description: 使用@Override注解重写父类方法
 * date: 2019/11/30 22:41
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Fruit {
    public void info() {
        System.out.println("水果的info方法...");
    }
}
class Apple extends Fruit {
    /**
     * 使用@Override指定下面方法必须重写父类方法
     */
    @Override
    public void info() {
        System.out.println("苹果重写水果的info方法...");
    }
}
