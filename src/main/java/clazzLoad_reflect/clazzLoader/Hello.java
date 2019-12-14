package clazzLoad_reflect.clazzLoader;

/**
 * ClassName: Hello
 * Description: 测试CompileClassLoader的使用，通过CompileClassLoader会自动编译并执行。
 * 使用命令时去掉包名
 * date: 2019/12/14 13:10
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class Hello {
    public static void main(String[] args) {
        for (String arg: args) {
            System.out.println("运行Hello的参数："+arg);
        }

        System.out.println(Hello.class.getName());

    }
}
