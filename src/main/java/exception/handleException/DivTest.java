package exception.handleException;

import java.util.Scanner;

/**
 * ClassName: DivTest
 * Description: 除法异常案例
 * date:
 * @author jingyuankui
 * @since JDK 1.8
 */
public class DivTest {
    public static void main(String[] args) {
        try {
            System.out.println("计算a/b，输入a：");
            Scanner sc1 = new Scanner(System.in);
            String a = sc1.nextLine();

            System.out.println("计算a/b，输入b：");
            Scanner sc2 = new Scanner(System.in);
            String b = sc2.nextLine();
            int c = Integer.parseInt(a)/Integer.parseInt(b);
            System.out.println("a/b = "+c);

            // 如果运行程序时输入的参数不够，会导致数组越界异常
        }catch (IndexOutOfBoundsException ie) {
            System.out.println("数组越界");
        }
        // 如果运行程序时输入的不是数字，会导致数字格式异常
        catch (NumberFormatException ne) {
            System.out.println("数字格式异常：程序只能接受整数参数");
        }
        // 如果运行程序时输入的除数是0，会导致算数异常
        catch (ArithmeticException ae) {
            System.out.println("算数异常");
        }
        catch (Exception e) {
            System.out.println("未知异常");
        }
    }
}
