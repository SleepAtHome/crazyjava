package exception.handleException;

import java.util.Date;

/**
 * ClassName: NullTest
 * Description: 空指针异常
 * date:
 * @author jingyuankui
 * @since JDK 1.8
 */
public class NullTest {
    public static void main(String[] args) {
        Date date = null;
        try {
            System.out.println(date.after(new Date()));
        } catch (NullPointerException ne) {
            System.out.println("空指针异常");
        } catch (Exception e) {
            System.out.println("未知异常");
        }
    }
}
