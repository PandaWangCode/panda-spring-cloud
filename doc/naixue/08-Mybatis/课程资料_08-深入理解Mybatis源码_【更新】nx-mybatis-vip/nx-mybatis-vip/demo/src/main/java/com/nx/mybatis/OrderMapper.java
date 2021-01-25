package com.nx.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> queryById(@Param("id") Long id);
    int updateByPrimaryKey(Order record);
}
