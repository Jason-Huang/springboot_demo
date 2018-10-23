package cn.jason.demo.administrativeDivision;

import cn.jason.demo.cbbaoguanzhijian.OperateOracle;
import cn.jason.demo.cbbaoguanzhijian.ZhiJian;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseService {
    public ZhiJian getZhiJianData(String merOrderId, OperateOracle oo) throws SQLException {
        //创建OperateOracle对象

        String sql = "select * from dic_country_info_scan";
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
        }
        return null;
    }
}
