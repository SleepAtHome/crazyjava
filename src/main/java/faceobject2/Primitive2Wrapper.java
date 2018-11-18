package faceobject2;

/**
 * 基本数据类型的包装类——用法
 */
public class Primitive2Wrapper {
    public static void main(String[] args) {
        boolean b = true;
        Boolean aBoolean = new Boolean(b);

        int i = 5;
        Integer integer = new Integer(i);

        Float fobj = new Float("4.556");
        Boolean bobj = new Boolean("false");

        // java.lang.NumberFormatException
        // Long lobj = new Long("ddd");

        System.out.println("-----------------------------------");

        boolean bb = bobj.booleanValue();
        int ii = integer.intValue();
        float ff = fobj.floatValue();
    }
}
