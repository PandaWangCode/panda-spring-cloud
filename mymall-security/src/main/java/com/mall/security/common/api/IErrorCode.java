package com.mall.security.common.api;

/**
  * @author Administrator
  * @create 2021-02-14
  * @desc 封装API的错误码
**/
public interface IErrorCode {

    /** 获取错误编码 **/
    long getCode();

    /** 获取错误消息**/
    String getMessage();

}
