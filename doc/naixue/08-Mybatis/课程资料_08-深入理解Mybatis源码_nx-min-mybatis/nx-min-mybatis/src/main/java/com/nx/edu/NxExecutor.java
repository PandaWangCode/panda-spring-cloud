package com.nx.edu;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Author:   mkp
 * Date:     2021/1/18 22:23
 * Description:
 */
public class NxExecutor {
    private static final String url = "jdbc:mysql://localhost:3306/nx_mybatis?serverTimezone=GMT%2B8";
    private static final String userName = "root";
    private static final String password = "root";
    public Object query(String sql, Object arg)  {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Order order = new Order();
        // 1、加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2、 获取连接
             conn = DriverManager.getConnection(url, userName, password);
            // 3、 创建语句并且执行statement可以理解为是一个执行器
            statement = conn.createStatement();
            String sqlInfo = String.format(sql,arg);
             resultSet = statement.executeQuery(sqlInfo);
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                Long amount = resultSet.getLong("amount");
                long userId = resultSet.getLong("user_id");
                order.setId(id);
                order.setAmount(amount);
                order.setUserId(userId);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
       return order;

    }
}
