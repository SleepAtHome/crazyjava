package faceobject1;

/**
 * 递归
 * 设置f(0)=1, f(1)=4, f(n+2)=2*f(n+1)+f(n)
 * 求f(10)
 *
 * 另外 已知f(20)=1, f(21)=4, f(n+2)=2*f(n+1)+f(n)
 * 求f(10)
 * 提示：f(n) = f(n+2) - 2*f(n+1)
 */
public class Recursive {
    public static int fn(int n) {
        if (0 == n) {
            return 1;
        }else if (1 == n) {
            return 4;
        } else {
            // 调用自身
            return 2 * fn(n-1) +fn(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fn(10));
    }
}
