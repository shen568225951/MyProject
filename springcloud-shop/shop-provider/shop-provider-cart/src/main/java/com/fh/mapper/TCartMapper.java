package com.fh.mapper;

import com.fh.model.TCart;
import com.fh.model.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TCartMapper {
    int deleteByPrimaryKey(Long tcId);

    int insert(TCart record);

    int insertSelective(TCart record);

    TCart selectByPrimaryKey(Long tcId);

    int updateByPrimaryKeySelective(TCart record);

    int updateByPrimaryKey(TCart record);
    //根据用户ID 查询该用户购物车的所有信息
    List<TCart> selectCartByUserId(Long userId);
    //根据用户ID查询 更新过后的购物车的信息
    List<CartVo> selectCartVoByUserId(Long userId);
}