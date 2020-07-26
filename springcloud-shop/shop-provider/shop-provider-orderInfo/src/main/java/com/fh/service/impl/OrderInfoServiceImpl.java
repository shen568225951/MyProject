package com.fh.service.impl;

import com.fh.mapper.TOrderinfoMapper;
import com.fh.model.TOrderinfo;
import com.fh.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Autowired
    private TOrderinfoMapper orderinfoMapper;

    /**
     * 该方法时批量向订单详情表中添加数据
     * @param orderInfoList 这是从订单业务层传递过来的数据（里边为组装出来的 订单详情的 数据）
     */
    @Override
    public void addOrderInfo(List<TOrderinfo> orderInfoList) {
        orderinfoMapper.addOrderInfo(orderInfoList);
    }

    /**
     * 该方法时根据 订单表的订单Id查询对应的商品Id
     * @param orderId
     * @return
     */
    @Override
    public List<TOrderinfo> selectOrderInfoListByOrderId(Long orderId) {
        return orderinfoMapper.selectOrderInfoListByOrderId(orderId);
    }
}
