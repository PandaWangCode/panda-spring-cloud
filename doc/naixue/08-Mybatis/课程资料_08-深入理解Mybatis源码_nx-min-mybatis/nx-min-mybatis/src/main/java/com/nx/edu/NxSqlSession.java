package com.nx.edu;

/**
 * Author:   mkp
 * Date:     2021/1/18 22:23
 * Description:
 */
public class NxSqlSession {

    private NxConfiguration nxConfiguration;

    private NxExecutor nxExecutor;

    public NxSqlSession(NxConfiguration nxConfiguration, NxExecutor nxExecutor) {
        this.nxConfiguration = nxConfiguration;
        this.nxExecutor = nxExecutor;
    }

    public Object selectOne(String statementId, Object arg) {

        String sql = nxConfiguration.getSqlMap().getString(statementId);
        return nxExecutor.query(sql,arg);
    }


    public <T> T getMapper(Class mapperCls){
        return nxConfiguration.getMapper(mapperCls,this);
    }
}
