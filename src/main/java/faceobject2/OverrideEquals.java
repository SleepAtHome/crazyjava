package faceobject2;

/**
 * 重写equals方法，使得用equals判断两个Person对象名字和年龄相等就算相等。
 */
class Person {
    private String name;
    private String age;

    public Person() {}
    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            Person person = (Person) obj;
            // 这里的this指的是调用这个方法的对象，Person是传进来的另一个对象
            if (this.getAge().equals(person.getAge()) && this.getName().equals(person.getName())){
                return true;
            }
        }
        return false;
    }*/

    // 更加成熟的equals写法，上面那个instanceof并不能保证为同一个类的实例
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == Person.class){
            Person person = (Person) obj;
            // 这里的this指的是调用这个方法的对象，Person是传进来的另一个对象
            if (this.getAge().equals(person.getAge()) && this.getName().equals(person.getName())){
                return true;
            }
        }
        return false;
    }
}
public class OverrideEquals {
    public static void main(String[] args) {
        Person p1 = new Person("孙悟空","33");
        Person p2 = new Person("孙悟空","33");
        Person p3 = new Person("孙悟饭", "2");

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }

}
