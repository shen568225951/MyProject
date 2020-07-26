package com.fh.controller;

import com.fh.model.TOrderinfo;
import com.fh.service.IOrderInfoService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 15136
 */
@RestController
@RequestMapping("orderInfoController")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderInfoService;

    @RequestMapping("selectOrderInfoListByOrderId")
    public List<TOrderinfo> selectOrderInfoListByOrderId(Long orderId){
        return orderInfoService.selectOrderInfoListByOrderId(orderId);
    }

    @RequestMapping("addOrderInfo")
    public void addOrderInfo(List<TOrderinfo> orderInfoList){
        orderInfoService.addOrderInfo(orderInfoList);
    }
}
