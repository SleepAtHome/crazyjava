package multithread;

import java.util.Date;

/**
 * ClassName: SleepTest
 * Description: Thread类的sleep
 * date: 2019/11/11 22:53
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0 ; i<1000; i++) {
            System.out.println("当前时间--"+new Date());
            Thread.sleep(1000);
        }
    }
}
