package exception.useThrow;

import java.sql.SQLException;

/**
 * ClassName: ExceptionTranslation
 * Description: 异常转译
 * 实现工资计算的方法
 *
 * 设计模式之一：职责链模式（异常链）
 *
 * date: 2019/12/25 10:47
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class ExceptionTranslation {
    public void calSal() throws SalException {
        try {
            // 实现结算工资的业务逻辑...
            // 假装有一个SQLException
            throw new SQLException();

        } catch (SQLException sqlEx) {
            // 记录原始异常...

            throw new SalException("发生SQL异常");
        } catch (Exception e) {
            // 记录原始异常...

            throw new SalException("未知异常");

            /*
            如果想传递原始异常，则这样用
            throw new SalException(e);
             */

        }
    }
}
