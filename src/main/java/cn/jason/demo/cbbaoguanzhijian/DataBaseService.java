package cn.jason.demo.cbbaoguanzhijian;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseService {
    public ZhiJian getZhiJianData(String merOrderId, OperateOracle oo) throws SQLException {
        //创建OperateOracle对象

        String sql = "select t.pay_transaction_id,t.order_no,t.payer_name,trim(to_char(t.amount_paid, '999999999990.99')) amount_paid,t.pay_time " +
                "from cb_rmb_customs_payment t where t.order_no='" + merOrderId + "'";
        ResultSet resultSet = oo.SelectData(sql);
        try {
            while (resultSet.next()) {
                ZhiJian zj = new ZhiJian();
                zj.setMessageID(resultSet.getString("pay_transaction_id"));
                zj.setEnordercode(resultSet.getString("order_no"));
                zj.setPayorName(resultSet.getString("payer_name"));
                zj.setOrderFcy(resultSet.getString("amount_paid"));
                zj.setPayDate(resultSet.getString("pay_time"));
                zj.setPayNo(zj.getMessageID());
                zj.setPayFcy(zj.getOrderFcy());
                return zj;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            oo.pstm.close();
        }
        return null;
    }
}
