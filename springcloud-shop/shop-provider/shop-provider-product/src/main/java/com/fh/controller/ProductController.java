package com.fh.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.fh.model.TProduct;
import com.fh.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 15136
 */
@RestController
@RequestMapping("productController")
@CrossOrigin
public class ProductController {

    @Autowired
    private TProductService tProductService;

    /**
     * 查询所有商品信息用于Home展示商品页面
     */
    @RequestMapping("selectProductList")
    public List<TProduct> selectProductList(){
        return tProductService.selectProductList();
    }

    /**
     * 根据Pid查询商品用于商品详情页面
     * @param pid 商品ID
     * @return
     */
    @RequestMapping("selectProductInfoByPid")
    public TProduct selectProductInfoByPid(Long pid){
        TProduct tProduct =  tProductService.selectProductInfoByPid(pid);
        return tProduct;
    }

}
