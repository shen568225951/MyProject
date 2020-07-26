package com.fh.mapper;

import com.fh.model.TOrder;
import com.fh.model.TProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author 15136
 */
@Repository
@Mapper
public interface TOrderMapper {
    int deleteByPrimaryKey(Long toId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long toId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);


    /**
     * //根据用户ID查询用用户的订单详情表
     * @param userId
     * @return
     */
    List<TOrder> selectOrderListByUserId(Long userId);
}