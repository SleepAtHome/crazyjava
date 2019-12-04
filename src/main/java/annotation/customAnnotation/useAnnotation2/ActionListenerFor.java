package annotation.customAnnotation.useAnnotation2;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: ActionListenerFor
 * Description: 通过使用Annotation来简化事件编程
 * 在传统事件编程中总是需要通过addActionListener()方法来为事件源绑定事件监听器。
 * 在这里，通过@ActionListenerFor来为程序中的按钮绑定事件监听器。
 * date: 2019/12/5 0:09
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {
    /*
    定义一个成员变量，用于设置元数据
    这个listener成员变量用于保存监听器实现类
     */
    Class<? extends ActionListener> listener();
}
