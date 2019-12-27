package generics.deep;

/**
 * ClassName: A2
 * Description: 从泛型类派生子类（不包含泛型）
 * date: 2019/12/27 22:37
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class A2 extends Apple{
    @Override
    public String getInfo() {
        // 这里的super.getInfo()得到的是Object类型的
        return super.getInfo().toString();
    }
}
