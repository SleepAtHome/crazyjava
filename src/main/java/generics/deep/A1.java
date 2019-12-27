package generics.deep;

/**
 * ClassName: A1
 * Description: 从泛型类派生子类（注意返回值，看看是否需要与泛型保持一致）
 * date: 2019/12/27 22:34
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class A1 extends Apple<String> {
    @Override
    public String getInfo() {
        return "子类A1 "+super.getInfo();
    }
}
