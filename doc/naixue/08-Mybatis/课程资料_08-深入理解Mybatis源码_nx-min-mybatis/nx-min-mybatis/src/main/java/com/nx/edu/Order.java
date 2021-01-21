package com.nx.edu;


import java.io.Serializable;
import java.util.Date;

/**
 * Author:   mkp
 * Date:     2020/9/29 15:48
 * Description: 订单
 * @author Administrator
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -6742502281548892194L;
    private Long id;

    private Long amount;


    private Long userId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", amount=" + amount + ", userId=" + userId + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
