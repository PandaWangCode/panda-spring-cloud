package com.nx.edu;

/**
 * Author:   mkp
 * Date:     2021/1/18 22:38
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        NxSqlSession nxSqlSession = new NxSqlSession(new NxConfiguration(), new NxExecutor());
        OrderMapper mapper = nxSqlSession.getMapper(OrderMapper.class);
        Order order = mapper.queryById(620898339119480832L);
        System.out.println("order 信息：" + order);
    }
}
