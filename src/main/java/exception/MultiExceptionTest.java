package exception;

import java.util.Scanner;

public class MultiExceptionTest {
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

            // 捕获多种类型的异常时，异常的变量有隐式的final修饰
        } catch (IndexOutOfBoundsException | NumberFormatException | ArithmeticException ie) {
            System.out.println("数组越界/数字格式异常：程序只能接受整数参数/算数异常  之一");
            // ie = new ArithmeticException("test");  这行代码会编译报错，因为捕获多异常的ie默认有final修饰
        } catch (Exception e) {
            System.out.println("未知异常");
            e = new RuntimeException("RT Exception"); // 捕获一种类型异常，可以对异常对象进行操作
        }
    }
}
