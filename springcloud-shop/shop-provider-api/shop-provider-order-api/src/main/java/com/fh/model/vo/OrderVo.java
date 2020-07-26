package com.fh.model.vo;

import com.fh.model.TOrder;
import com.fh.model.TProduct;

import java.util.List;

public class OrderVo {

    /**
     * 这个类是用来接收 前端传递过来的参数
     *  分别向订单表和订单详情表中 添加数据
     *
     *
     * 参数  订单对象
     *      存放商品的集合
     *      存放商品ID 的集合
     *      存放商品数量的集合
     */

    //订单表
    private TOrder tOrder;

    //商品详情集合
    private List<TProduct> productList;

    //商品ID集合
    private List<Long> pids;
    //商品数量
    private List<Long> counts;

    public List<Long> getPids() {
        return pids;
    }

    public void setPids(List<Long> pids) {
        this.pids = pids;
    }

    public List<Long> getCounts() {
        return counts;
    }

    public void setCounts(List<Long> counts) {
        this.counts = counts;
    }

    public TOrder gettOrder() {
        return tOrder;
    }

    public void settOrder(TOrder tOrder) {
        this.tOrder = tOrder;
    }

    public List<TProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<TProduct> productList) {
        this.productList = productList;
    }
}
