package com.fh.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

    /**
     * 这个类是用来接取前端settle 提交订单页面 传递过来的参数
     * 用户ID
     * 订单价格
     * 传递过来的多个商品ID (用list集合在存放数据)
     * 用户姓名
     * 用户电话
     * 用户地址
     * 用户购物车下每个商品的数量 （用list集合存放数据）
     */

    private Long userId;

    private BigDecimal orderPrice;

    private List<Long> pids;

    private String orderUser;

    private String orderTel;

    private String orderAddr;

    private List<Long> pcount;

    public List<Long> getPcount() {
        return pcount;
    }

    public void setPcount(List<Long> pcount) {
        this.pcount = pcount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<Long> getPids() {
        return pids;
    }

    public void setPids(List<Long> pids) {
        this.pids = pids;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }
}
