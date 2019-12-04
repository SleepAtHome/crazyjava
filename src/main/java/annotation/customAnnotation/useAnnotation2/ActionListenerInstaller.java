package annotation.customAnnotation.useAnnotation2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * ClassName: ActionListenerInstaller
 * Description: 分析目标对象中所有的Field，如果该Field使用了@ActionListenerFor修饰，
 * 则取出该Annotation中的listener元数据，并根据该数据来绑定事件监听器。
 * date: 2019/12/5 0:21
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ActionListenerInstaller {
    /**
     * 处理Annotation的方法
     * @param obj : 包含Annotation的对象
     */
    public static void processAnnotations(Object obj) {
        try {
            // 得到obj对象的类
            Class cl = obj.getClass();
            // 获取obj对象的所有Field并遍历
            for (Field f: cl.getFields()) {
                // 将指定Field设置成可自由访问
                f.setAccessible(true);
                // 获取指定的 Field 上 ActionListenerFor 类型的 Annotation
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                // 获取f Field实际对应的对象
                Object fObj = f.get(obj);

                // 如果fObj是AbstractButton的实例，则为fObj添加事件监听器
                if (a!=null && fObj!=null && fObj instanceof AbstractButton) {
                    // 获取a这个Annotation里的元数据listener（是一个监听器类）
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    // 使用反射创建Listener类对象
                    ActionListener al = listenerClazz.newInstance();
                    AbstractButton ab = (AbstractButton) fObj;
                    // 为ab按钮（fObj按钮）添加事件监听器
                    ab.addActionListener(al);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
