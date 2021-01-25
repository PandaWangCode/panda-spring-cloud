package com.nx.mybatis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:   mkp
 * Date:     2020/10/10 15:58
 * Description:
 */
public class MybatisConnect {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 配置的解析
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取会话
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 获取mapper
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            // 执行对应的sql
            List<Order> orders = orderMapper.queryById(620898339119480832L);
            System.out.println(JSON.toJSONString(orders));
        }
    }
}
