package faceobject1;

/**
 * 一个构造器调用另一个构造器（用this）
 */
public class Apple {
    public String name;
    public String color;
    public double weight;

    public Apple() {}

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // 这个构造器调用两个参数的构造器
    public Apple(String name, String color, double weight) {
        this(name, color);
        this.weight = weight;
    }
}
