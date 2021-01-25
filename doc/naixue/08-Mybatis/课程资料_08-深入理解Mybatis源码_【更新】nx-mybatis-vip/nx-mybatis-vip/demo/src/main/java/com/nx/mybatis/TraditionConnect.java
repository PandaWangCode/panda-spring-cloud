package com.nx.mybatis;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Author:   mkp
 * Date:     2020/9/29 14:58
 * Description: 传统连接
 */
public class TraditionConnect {
    private static final String url = "jdbc:mysql://localhost:3306/nx_mybatis?serverTimezone=GMT%2B8";
    private static final String userName = "root";
    private static final String password = "root";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            // 1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、 获取连接
            Connection conn = DriverManager.getConnection(url, userName, password);
            // 3、 创建语句并且执行statement可以理解为是一个执行器
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `order`");
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                long userId = resultSet.getLong("user_id");
                System.out.println("数据库中的信息 " + id  + "  " + amount + "  " + userId);
            }
            resultSet.close();
            statement.close();
            conn.close();
    }
}
