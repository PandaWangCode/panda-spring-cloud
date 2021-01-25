package com.nx.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:   mkp
 * Date:     2020/11/16 15:53
 * Description:
 */
public class MybatisFirstConnect {
    public static void main(String[] args) throws IOException {


            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
            try {
                List<Order> orders =  session.selectList("com.nx.mybatis.example.OrderMapper.queryById", 620898339119480832L);
                System.out.println(orders);
            } finally {
                session.close();
            }
        }

}
