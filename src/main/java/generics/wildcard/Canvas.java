package generics.wildcard;

import java.util.List;

/**
 * ClassName: Canvas
 * Description: 类型通配符的上限——画布
 * date: 2020/1/1 16:02
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Canvas {
    /**
     * 同时在画布上画多个形状
     * 如这里使用List<Shape>，则使用这个方法时不能用List<Circle>，因为List<Circle>不是List<Shape>的子类
     * 如这里使用List<？>，则需要使用强转
     * 如这里使用List<? extends Shape>，则只要是Shape的子类都可以（可以是Shape本身）
     * @param shapes
     */
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s: shapes) {
            s.draw(this);
        }
    }

    public void addRectangle(List<? extends Shape> shapes) {
        // 下方代码编译错误,因为不知道传进来的Shape的具体类型，可能是Circle
        // shapes.add(0, new Rectangle());
    }
}
