package faceobject1;

class Root {
    static {
        System.out.println("Root's static Initialization block");
    }
    public Root() {
        System.out.println("Root's constructor(无参)");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid's static Initialization block");
    }
    {
        System.out.println("Mid's Initialization block");
    }
    public Mid() {
        System.out.println("Mid's constructor(无参)");
    }
    public Mid(String msg) {
        this();
        System.out.println("Mid's constructor("+msg+")");
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf's static Initialization block");
    }
    {
        System.out.println("Leaf's Initialization block");
    }
    public Leaf() {
        super("Crazy Java!!");
        System.out.println("Leaf's constructor(无参)");
    }
}

public class Test {
    public static void main(String[] args) {
        new Leaf(); // 第一次初始化Leaf类，静态初始化块执行
        System.out.println("--------------------------------");
        new Leaf(); // 静态初始化块不执行，因为系统中已经有Leaf类了
    }
}
