package faceobject1;

/**
 * 方法的重载
 */
public class Overload {
    public void test() {
        System.out.println("无参数..");
    }

    public void test(String msg) {
        System.out.println("重载的test方法，参数是：" +msg);
    }

    public static void main(String[] args) {
        Overload o1 = new Overload();
        o1.test();
        o1.test("Hello");
    }
}
