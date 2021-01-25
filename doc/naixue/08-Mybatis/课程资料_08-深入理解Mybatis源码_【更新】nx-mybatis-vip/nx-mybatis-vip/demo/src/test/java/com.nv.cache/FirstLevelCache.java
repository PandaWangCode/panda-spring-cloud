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
 * Date:     2020/10/15 14:36
 * Description: 测试一级缓存必须先关闭二级缓存否则就会相互影响
 */
public class FirstLevelCache {
    // 一级缓存同一个会话共享 不同会话不能共享
    @Test
    public void testSession() throws IOException {
        String resource = "mybatis-cache.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 同一个会话  第一次查询
            System.out.println("第一次会会话的  第一次查询");
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<Order> orders = orderMapper.queryById(620898339119480832L);

            // 同一个会话  第二次查询
            System.out.println("第一次会会话的  第二次查询");
            OrderMapper orderMapper2 = sqlSession.getMapper(OrderMapper.class);
            List<Order> orders2 = orderMapper2.queryById(620898339119480832L);
            System.out.println(JSON.toJSONString(orders));
        }

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            System.out.println("第二个会话 第一次查询");
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<Order> orders = orderMapper.queryById(620898339119480832L);
            System.out.println(JSON.toJSONString(orders));
        }
    }
    // 同一个会话如果有更新操作会缓存清除
    @Test
    public void testUpdate() throws IOException {
        String resource = "mybatis-cache.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 同一个会话  第一次查询
            System.out.println("第一次会会话的  第一次查询");
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<Order> orders = orderMapper.queryById(620898339119480832L);
            Order order = orders.get(0);
            order.setAmount(12L);
            orderMapper.updateByPrimaryKey(order);
            // 同一个会话  第二次查询
            System.out.println("第一次会会话的  第二次查询");
            List<Order> orders2 = orderMapper.queryById(620898339119480832L);
            System.out.println(JSON.toJSONString(orders2));
        }
    }
    // 一级缓存作用域是在sqlSession里面，不共享导致脏数据
    @Test
    public void testDirtyData() throws IOException {
        String resource = "mybatis-cache.xml";
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
            sqlSession1.commit(true);
            Order order1 = getOrder(orders);
            System.out.println("=========更新数据======");
            orderMapper2.updateByPrimaryKey(order1);
            sqlSession2.commit();
            System.out.println("第一次次会话的 第二次查询 " );
            List<Order> orders1 =  orderMapper1.queryById(620898339119480832L);
            System.out.println("第二次查询："+JSON.toJSONString(orders1));


        }catch (Exception e){
            sqlSession1.close();

        }
    }

    private Order getOrder(List<Order> orders) {
        Order order = orders.get(0);
        Order order1 = new Order();
        order1.setId(620898339119480832L);
        order1.setCreateTime(order.getCreateTime());
        order1.setUpdateTime(order.getUpdateTime());
        order1.setUserId(order.getUserId());
        order1.setAmount(666L);
        return order1;
    }

}
