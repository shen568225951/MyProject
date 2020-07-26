package com.fh.service;

import com.fh.model.TOrderinfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 15136
 *  微服务的名字
 */
@FeignClient("shop-provider-orderInfo")
public interface OrderInfoFeignService {

    /**
     * 根据订单Id查询订单详情列表
     * @param orderId
     * @return
     */
    @RequestMapping("orderInfoController/selectOrderInfoListByOrderId")
    List<TOrderinfo> selectOrderInfoListByOrderId(Long orderId);

    /**
     * 向订单详情表中添加数据
     * @param orderInfoList
     */
    @RequestMapping("orderInfoController/addOrderInfo")
    void addOrderInfo(List<TOrderinfo> orderInfoList);
}
