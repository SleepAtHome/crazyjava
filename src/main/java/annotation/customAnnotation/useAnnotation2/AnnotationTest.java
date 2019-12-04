package annotation.customAnnotation.useAnnotation2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName: AnnotationTest
 * Description: 测试@ActionListenerFor
 * date: 2019/12/5 0:13
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class AnnotationTest {
    private JFrame mainWin = new JFrame("JYK使用Annotation绑定事件监听器");

    @ActionListenerFor(listener = OkListener.class)
    private JButton okButton = new JButton("确定");

    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancelButton = new JButton("取消");

    public void init() {
        // 初始化界面
        JPanel jPanel = new JPanel();
        jPanel.add(okButton);
        jPanel.add(cancelButton);
        mainWin.add(jPanel);

        ActionListenerInstaller.processAnnotations(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }
}

/**
 * 定义ok按钮的时间监听器实现类
 */
class OkListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"单击了确认按钮");
    }
}

/**
 * 定义cancel按钮的时间监听器实现类
 */
class CancelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"单击了取消按钮");
    }
}
