package faceobject2;

public class TestFinalVariable {
    final int a = 6;

    // 这里要指定默认值，要么就哟在下面的初始化块中或者构造器中定义初始值，不然不合法
    final String str;
    final int c;
    final static double d;
    // final char ch;

    {
        str = "Hello";
        // a已经指定了默认值
        // a = 9;
    }

    static {
        d = 5.6;
    }

    public TestFinalVariable() {
        // 在初始化块中已经对str赋值过了
        // str = "java";
        c = 5;
    }

    // final修饰形参
    public void test(final int a) {
        // 不能再对a进行赋值
        // a = 5;
    }

}
