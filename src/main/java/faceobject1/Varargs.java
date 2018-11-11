package faceobject1;

/**
 * 可变长形参（会被当成数组传入）
 */
public class Varargs {
    public static void test(int a, String... books) {
        for (String str : books) {
            System.out.println(str);
        }
        System.out.println(a);
    }
    public static void main(String[] args) {
        test(5, "疯狂java", "Spring In Action", "Redis");
    }
}
