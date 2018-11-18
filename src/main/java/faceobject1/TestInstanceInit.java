package faceobject1;

public class TestInstanceInit {
    {
        // 初始化块可以这样用
        a = 6;
    }
    int a = 9;

    public static void main(String[] args) {
        System.out.println(new TestInstanceInit().a);
    }
}
