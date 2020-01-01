package generics.wildcard;

/**
 * ClassName: Rectangle
 * Description: 类型通配符的上限——矩形
 * date: 2020/1/1 15:57
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Rectangle extends Shape{

    @Override
    public void draw(Canvas c) {
        System.out.println("在画布"+c+"上画一个矩形");
    }
}
