package com.fh.service;

import com.fh.model.dto.CreateOrderDto;
import com.fh.model.dto.OrderDto;
import com.fh.model.vo.OrderVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IOrderService {
    void addOrder(OrderVo orderVo);

    void addOrder(OrderDto orderDto, HttpServletResponse response);

    List<CreateOrderDto> getOrderList(Long userId);
}
