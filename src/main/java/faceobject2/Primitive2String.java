package faceobject2;

/**
 * 基本数据类型的包装类——基本数据类型的变量和字符串之间的转换
 * 除了Character类型
 */
public class Primitive2String {
    public static void main(String[] args) {
        String intstr = "123";
        int i = Integer.parseInt(intstr);
        System.out.println(i);

        String floatstr = "45.67";
        float f = Float.parseFloat(floatstr);
        System.out.println(f);

        System.out.println("------------------------");

        String ftStr = String.valueOf(12.34f);
        System.out.println(ftStr);

        String dbStr = String.valueOf(3.344);
        System.out.println(dbStr);

        String boolStr = String.valueOf(true);
        System.out.println(boolStr);

    }
}
