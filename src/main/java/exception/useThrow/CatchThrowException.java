package exception.useThrow;

/**
 * ClassName: CatchThrowException
 * Description: 竞拍：catch结合throw同时使用
 * date: 2019/12/24 22:09
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class CatchThrowException {
    private double initPrice = 30.0;
    public void bid(String bidPrice) throws customException {
        double d = 0.0;
        try {
            d = Double.parseDouble(bidPrice);
        } catch (Exception e) {
            e.printStackTrace();
            throw new customException("竞拍价必须是数值，不能包含其他字符！");
        }
        if (initPrice > d) {
            throw new customException("竞拍价比起拍价低，不允许竞拍");
        }
        initPrice = d;
    }

    public static void main(String[] args) {
        CatchThrowException c = new CatchThrowException();
        try {
            c.bid("df");
        } catch (customException e) {
            System.out.println("进行异常处理。。。");
            e.printStackTrace();
        }
    }
}
