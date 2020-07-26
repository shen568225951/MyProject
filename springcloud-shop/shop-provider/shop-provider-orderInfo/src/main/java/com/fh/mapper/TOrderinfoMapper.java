package com.fh.mapper;

import com.fh.model.TOrderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author 15136
 */
@Component
@Mapper
public interface TOrderinfoMapper {
    int deleteByPrimaryKey(Long toiId);

    int insert(TOrderinfo record);

    int insertSelective(TOrderinfo record);

    TOrderinfo selectByPrimaryKey(Long toiId);

    int updateByPrimaryKeySelective(TOrderinfo record);

    int updateByPrimaryKey(TOrderinfo record);

    /**
     * 批量向订单详情表中添加数据
     * @param orderinfoList
     */
    void addOrderInfo(List<TOrderinfo> orderinfoList);


    /**
     * 根据订单表的订单ID查询订单详情表中的商品ID
     * @param orderId
     * @return
     */
    List<TOrderinfo> selectOrderInfoListByOrderId(Long orderId);
}