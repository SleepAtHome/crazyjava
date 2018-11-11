package faceobject1;

/**
 * 测试this
 */
public class Dog {
    public void jump() {
        System.out.println("jumping....");
    }

    public void run() {
        // 如果不用this的话，就只能new一个Dog的对象
        // this.jump(); 这个this可以省略
        jump();
        System.out.println("running...");
    }

    public static void main(String[] args) {
        // 这里不能直接访问run方法或者jump方法，因为他们需要用一个实例去调用
        Dog dog = new Dog();
        dog.run();
    }
}
