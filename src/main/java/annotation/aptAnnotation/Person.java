package annotation.aptAnnotation;

/**
 * ClassName: Person
 * Description: 使用APT工具
 * 使用@Persistent、@ID、@Property这三个Annotation
 * 要写一个Annotation处理器处理这个类
 * 这个处理器的功能就是根据Annotation来生成一个Hibernate映射文件（一份XML文件）
 * date: 2019/12/7 16:07
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
@Persistent(table = "jyk_person")
public class Person {
    @Id(column = "person_id", type = "intrger", generator = "identity")
    private int id;
    @Property(column = "person_name", type = "string")
    private String name;
    @Property(column = "person_age", type = "integer")
    private int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
