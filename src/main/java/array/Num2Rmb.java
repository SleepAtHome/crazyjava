package array;

import java.util.Arrays;

/**
 * 数字转人民币(4位)
 * 中文数字是4位一分，分别是元、万、亿
 */
public class Num2Rmb {
    private String[] hanArr = {"零" ,"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private String[] unitArr = {"拾", "佰", "仟"};

    /**
     * 把一个浮点数分解成整数部分和小数部分的字符串
     * @param num 需要被分解的浮点数
     * @return 分解出来的整数部分和小数部分，数组中的第一个元素是整数部分，第二个元素是小数部分
     */
    private String[] divide(double num) {
        // 将double强转为long，得到整数部分
        long zhengshu = (long)num;

        // 将浮点数减去整数部分，在把小数部分*100再取整，得到(原来的)两位的小数部分
        long xiaoshu = Math.round((num - zhengshu) * 100);

        return new String[]{zhengshu + "", String.valueOf(xiaoshu)};
    }

    /**
     * 把一个四位数的数字转换为汉字
     * @param numStr 数字
     * @return 数字对应的汉字
     */
    private String toHanStr(String numStr) {
        String result = "";
        int numLen = numStr.length();

        for (int i = 0; i < numLen; i++) {
            // 将char型数字转换为int型，相差48
            int num = numStr.charAt(i)-48;

            // 如果不是最后一个数字，而且数字不是零，就要加单位
            if (i != numLen -1 && num != 0) {
                // 这里后面-2是因为传进来的是4位数
                result += hanArr[num] + unitArr[numLen -2 -i];
            } else {
                result += hanArr[num];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Num2Rmb nr = new Num2Rmb();
        System.out.println(Arrays.toString(nr.divide(7384723.4832)));
        System.out.println(nr.toHanStr("7468"));
    }

}
