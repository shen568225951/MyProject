package com.fh.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateOrderDto {

    /**
     * 前端 我的订单 展示的字段
     * 订单创建时间
     * 订单编号
     * 总价格
     * 商品信息
     */

    private Date createTime;

    private Long orderNum;

    private BigDecimal totalPrice;

    List<ProductDto> productDtoList;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }
}
