package com.nx.edu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author:   mkp
 * Date:     2021/1/18 22:24
 * Description:
 */
public class NxMapperProxy implements InvocationHandler {


    private NxSqlSession nxSqlSessionl;

    public NxMapperProxy(NxSqlSession nxSqlSessionl) {
        this.nxSqlSessionl = nxSqlSessionl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName() + "." + method.getName();
        return nxSqlSessionl.selectOne(statementId,args[0]);
    }
}
