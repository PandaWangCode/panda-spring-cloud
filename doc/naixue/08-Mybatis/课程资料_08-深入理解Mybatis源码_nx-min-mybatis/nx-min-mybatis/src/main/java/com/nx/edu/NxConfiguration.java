package com.nx.edu;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * Author:   mkp
 * Date:     2021/1/18 22:22
 * Description:
 */
public class NxConfiguration {

    private ResourceBundle sqlMap = null;

    public NxConfiguration() {
        this.sqlMap = ResourceBundle.getBundle("sql");
    }

    public ResourceBundle getSqlMap() {
        return sqlMap;
    }

    public <T> T getMapper(Class mapperCls, NxSqlSession nxSqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{mapperCls},
                new NxMapperProxy(nxSqlSession));
    }
}
