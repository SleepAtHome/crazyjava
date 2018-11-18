package faceobject2;

/**
 * 自动装箱、自动拆箱
 */
public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        // 自动装箱
        Integer integer = 5;
        Object boolObj = true;

        // 自动拆箱
        int i = integer;
        if (boolObj instanceof Boolean) {
            Boolean b = (Boolean) boolObj;
            System.out.println(b);
        }
    }
}
