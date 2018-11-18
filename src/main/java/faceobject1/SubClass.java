package faceobject1;

/**
 * 多态例子
 */
class BasicClass{
    public int book = 6;
    public void base() {
        System.out.println("父类的普通方法");
    }
    public void test() {
        System.out.println("父类的被覆盖的方法");
    }
}
public class SubClass  extends BasicClass{

    // 重新定义book
    public String book = "疯狂Java";
    @Override
    public void test() {
        System.out.println("子类覆盖父类的方法");
    }
    public void sub() {
        System.out.println("子类的普通方法");
    }

    public static void main(String[] args) {
        BasicClass bc = new BasicClass();
        System.out.println(bc.book);
        bc.base();
        bc.test();

        SubClass sc = new SubClass();
        System.out.println(sc.book);
        sc.base();
        sc.test();

        // 多态
        BasicClass ploymophicBc = new SubClass();
        // 输出6——访问的是父类属性
        System.out.println(ploymophicBc.book);
        ploymophicBc.base();
        // 执行当前类的test
        ploymophicBc.test();

        // 因为编译的时候编译的是父类，所以调用子类的方法时会出错
        // ploymophicBc.sub;

    }
}
