package com.mall.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: mapper配置文件
 * Author: wangpan
 * Date: 2021-02-15 下午 4:02
 **/
@Configuration
@MapperScan("com.mall.mybatis.mbg.mapper")
public class MyMapperConfig {

}
