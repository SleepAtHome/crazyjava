package faceobject1;

/**
 * 子类和父类的构造器执行顺序
 *
 * 最后结果：
 * Creature 0 parameter constructor....
 * Animal 1 parameter constructor == woooolf
 * Animal 2 parameter constructor == 3
 * Wolf 0 parameter constructor
 */
class Creature {
    public Creature() {
        System.out.println("Creature 0 parameter constructor....");
    }
}

class Animal extends Creature {
    public Animal(String name) {
        System.out.println("Animal 1 parameter constructor == "+name);
    }

    public Animal(String name,int age) {
        this(name);
        System.out.println("Animal 2 parameter constructor == "+ age);
    }
}

public class Wolf extends Animal{
    public Wolf() {
        super("woooolf",3);
        System.out.println("Wolf 0 parameter constructor");
    }

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
    }
}
