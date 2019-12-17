package clazzLoad_reflect.useReflect;

import java.lang.reflect.Field;

/**
 * ClassName: FieldTest
 * Description: 使用反射访问属性值
 * date: 2019/12/17 22:06
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class FieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Class<Person> personClzz = Person.class;

        // 获取Field（private也行）
        Field nameField = personClzz.getDeclaredField("name");
        // 取消该Field的权限访问检查
        nameField.setAccessible(true);
        // 给该Field赋值
        nameField.set(p, "Yuankui Jing");
        Field ageField = personClzz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(p, 23);

        System.out.println(p);
    }

}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person[name: "+name+" ,age "+age+" ]";
    }
}
