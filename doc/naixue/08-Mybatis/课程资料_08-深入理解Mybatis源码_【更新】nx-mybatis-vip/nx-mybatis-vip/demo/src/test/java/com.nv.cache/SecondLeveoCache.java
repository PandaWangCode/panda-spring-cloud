package com.nv.cache;

import com.alibaba.fastjson.JSON;
import com.nx.mybatis.Order;
import com.nx.mybatis.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:   mkp
 * Date:     2020/10/15 16:51
 * Description: 二级缓存
 */
public class SecondLeveoCache {
    /**
     * 跨会话共享
     * @throws IOException
     */
    @Test
    public void testSession() throws IOException {
        String resource = "mybatis-cacheSecond.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        try {
            // 同一个会话  第一次查询
            System.out.println("第一次会会话的  第一次查询");
            OrderMapper orderMapper = sqlSession1.getMapper(OrderMapper.class);
            List<Order> orders = orderMapper.queryById(620898339119480832L);
            System.out.println(JSON.toJSONString(orders));
            // 事务如果不提交情况下是不会写入 到二级缓存的
            sqlSession1.commit();
            System.out.println("第二个会话 第一次查询");
            OrderMapper orderMapper2 = sqlSession2.getMapper(OrderMapper.class);
            List<Order> orders2 = orderMapper2.queryById(620898339119480832L);
            System.out.println(JSON.toJSONString(orders2));
        }finally {
            sqlSession1.close();
            sqlSession2.close();
        }
    }


    @Test
    public void testDirtyData() throws IOException {
        String resource = "mybatis-cacheSecond.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        try {
            // 同一个会话  第一次查询
            OrderMapper orderMapper1 = sqlSession1.getMapper(OrderMapper.class);
            OrderMapper orderMapper2 = sqlSession2.getMapper(OrderMapper.class);

            List<Order> orders = orderMapper1.queryById(620898339119480832L);
            System.out.println("第一次会会话第一次查询的结果" + orders);
            Order order1 = getOrder(orders);
            sqlSession1.commit(true);
            orderMapper2.updateByPrimaryKey(order1);
            sqlSession2.commit();
            System.out.println("第二次查询查看是否命中缓存");
            orderMapper1.queryById(620898339119480832L);

        }catch (Exception e){
            sqlSession1.close();
            sqlSession2.close();
        }
    }

    private Order getOrder(List<Order> orders) {
        Order order = orders.get(0);
        Order order1 = new Order();
        order1.setId(620898339119480832L);
        order1.setCreateTime(order.getCreateTime());
        order1.setUpdateTime(order.getUpdateTime());
        order1.setUserId(order.getUserId());
        order1.setAmount(888L);
        return order1;
    }


}
