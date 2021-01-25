package com.nx.mybatis;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:   mkp
 * Date:     2020/9/29 15:48
 * Description: 订单
 * @author Administrator
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -6742502281548892194L;
    private Long id;

    private Long amount;


    private Long userId;

    private Date createTime;

    private Date updateTime;

}
