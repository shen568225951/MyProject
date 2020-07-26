package com.fh.model.dto;

import java.math.BigDecimal;

public class ProductDto {

    /**
     * 用来存放商品相关的信息
     * 在 查询  我的订单  使用了这个类
     *
     * 参数：商品名称
     *      商品价格
     *      商品图片
     *      商品数量
     */

    private String pname;

    private BigDecimal price;

    private String pimg;

    private Long pcount;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public Long getPcount() {
        return pcount;
    }

    public void setPcount(Long pcount) {
        this.pcount = pcount;
    }
}
