package generics.wildcard;

/**
 * ClassName: Circle
 * Description: 类型通配符的上限——圆类
 * date: 2020/1/1 15:56
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Circle extends Shape{

    @Override
    public void draw(Canvas c) {
        System.out.println("在画布"+c+"上画一个圆");
    }
}
