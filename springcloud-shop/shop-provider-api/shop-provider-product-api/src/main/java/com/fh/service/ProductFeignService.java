package com.fh.service;

import com.fh.model.TProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 15136
 *
 * 微服务的名字
 */
@FeignClient("shop-provider-product")
public interface ProductFeignService {

    /**
     * 查询所有商品信息
     * @return
     */
    @RequestMapping("productController/selectProductList")
    List<TProduct> selectProductList();

    /**
     * 根据商品Id查询商品详情信息
     * @param pid
     * @return
     */
    @RequestMapping("productController/selectProductInfoByPid")
    TProduct selectProductInfoByPid(Long pid);

    /**
     * 根据商品ID  批量查询商品数据
     * @param pids
     * @return
     */
    @RequestMapping("productController/selectProductsByPids")
    List<TProduct> selectProductsByPids(List<Long> pids);
}
