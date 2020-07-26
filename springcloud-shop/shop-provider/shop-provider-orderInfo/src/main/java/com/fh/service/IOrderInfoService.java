package com.fh.service;

import com.fh.model.TOrderinfo;

import java.util.List;

/**
 * @author 15136
 */
public interface IOrderInfoService {
    void addOrderInfo(List<TOrderinfo> orderInfoList);

    List<TOrderinfo> selectOrderInfoListByOrderId(Long orderId);
}
