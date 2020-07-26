package com.fh.controller;

import com.fh.model.dto.CreateOrderDto;
import com.fh.model.dto.OrderDto;
import com.fh.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 15136
 */
@RestController
@RequestMapping("orderController")
@CrossOrigin
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    /**
     * 该方法时前端点击提交订单， 然后后端根据传递的参数来向数据库的订单表和订单详情表中添加数据
     * @param orderDto 这是用来接收前端传递过来的参数
     */
    @RequestMapping("addOrder")
    public void addOrder(OrderDto orderDto, HttpServletResponse response){
        iOrderService.addOrder(orderDto,response);
    }

    /**
     * 该方法是根据用户的ID 来查询该用户下的订单表的数据
     * @param userId
     * @return
     */
    @RequestMapping("getOrderList")
    public List<CreateOrderDto> getOrderList(Long userId){
        return iOrderService.getOrderList(userId);
    }

}
