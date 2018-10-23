package cn.jason.demo.cbbaoguanzhijian;

import java.sql.*;

public class OperateOracle {

    // 定义连接所需的字符串
    // 192.168.0.X是本机地址(要改成自己的IP地址)，1521端口号，XE是精简版Oracle的默认数据库名


    private static String USERNAMR = "newcieccrdonly";
    private static String PASSWORD = "qCIaLgedHwzpfDeP";
    private static String DRVIER = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)\n" +
            "(HOST=223.203.208.109)(PORT=1521)))\n" +
            "(CONNECT_DATA=(SERVICE_NAME=bfdb)))";


//        private static String USERNAMR = "newcieccpay_test";
//        private static String PASSWORD = "newcieccpay_test";
//        private static String DRVIER = "oracle.jdbc.OracleDriver";
//        private static String URL = "jdbc:oracle:thin:@192.168.1.202:1521:rac";



    // 创建一个数据库连接
    Connection connection = null;
    // 创建预编译语句对象，一般都是用这个而不用Statement
    PreparedStatement pstm = null;
    // 创建一个结果集对象
    ResultSet rs = null;

    /**
     * 向数据库中查询数据
     */
    public ResultSet SelectData(String sql) {
        if(connection == null){
            connection = getConnection();
        }
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取Connection对象
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(DRVIER);
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not find !", e);
        } catch (SQLException e) {
            throw new RuntimeException("get connection error!", e);
        }

        return connection;
    }

    /**
     * 释放资源
     */
    public void ReleaseResource() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}