package com.fh.controller;

import com.fh.model.TProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 15136
 */
@RestController
public class TestRibbonConfig {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("selectProductList")
    public List<TProduct> selectProductList(){
        return restTemplate.getForObject("http://shop-provider-product/productController/selectProductList",List.class);
    }

}
