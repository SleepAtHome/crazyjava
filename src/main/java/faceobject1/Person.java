package faceobject1;

/**
 * 封装
 */
public class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>100 || age<0){
            System.out.println("设置的年龄不合法");
            return;
        }else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 6 || name.length() < 2) {
            System.out.println("输入的人名不符合要求");
            return;
        }
        this.name = name;
    }
}
