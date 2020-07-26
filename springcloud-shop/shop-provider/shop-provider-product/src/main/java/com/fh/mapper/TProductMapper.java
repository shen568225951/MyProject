package com.fh.mapper;

import com.fh.model.TProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TProductMapper {
    int deleteByPrimaryKey(Long tpId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Long tpId);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);

    //查询所有的商品信息
    List<TProduct> selectProductList();

    //根据商品的 pid  查询 商品信息
    TProduct selectProductInfoByPid(Long pid);

    //根据商品的 pids  批量查询商品信息
    List<TProduct> selectProductsByPids(List<Long> pids);
}