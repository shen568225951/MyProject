package com.fh.service;

import com.fh.model.TProduct;

import java.util.List;

public interface TProductService {
    void addProduct(TProduct tproduct);

    List<TProduct> selectProductList();

    /**
     * 根据商品ID查询商品详情
     * @param pid
     * @return
     */
    TProduct selectProductInfoByPid(Long pid);

    List<TProduct> selectProductsByPids(List<Long> pids);
}
