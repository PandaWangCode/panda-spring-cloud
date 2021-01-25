package com.nx.mybatis.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:   mkp
 * Date:     2020/11/16 11:46
 * Description:
 */
public class CourseProxy implements InvocationHandler {
    private Object target;


    public Object getTarget() {
        return (Object) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" hello world");
        method.invoke(target,args);
        return null;
    }
}
