package generics.wildcard;

/**
 * ClassName:Apple2 为类型形参设定多个上限（最多有一个父类上限，可以有多个接口上限）
 * Description: 表明T必须是Number类或是其子类，并必须实现java.io.Serializable接口
 * date: 2020-01-02 21:40
 *
 * @author Yuankui Jing
 * @since JDK 1.8
 */
public class Apple2<T extends Number & java.io.Serializable> {
    // ...
}
