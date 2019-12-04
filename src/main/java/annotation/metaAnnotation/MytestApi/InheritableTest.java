package annotation.metaAnnotation.MytestApi;

import annotation.metaAnnotation.Inheritable;

/**
 * @description: InheritableTest并未直接使用@Inheritable，而是继承了Base
 *
 * 使用@Inheritable注解（此注解被@Inherited注释）
 * @author: Jingyuankui
 * @time: 2019/12/4 12:54
 */
public class InheritableTest extends Base {
    public static void main(String[] args) {
        // 打印InheritableTest是否被@Inheritable修饰
        System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }
}

/**
 * 使用@Inheritable注解的Base类
 */
@Inheritable
class Base{}
