package com.fh.controller;

import com.fh.bean.Brand;
import com.fh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 15136
 */
@RestController
@RequestMapping("brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService service;

    @RequestMapping("selectBrandList")
    public List<Brand> selectBrandList(){
        return service.selectBrandList();
    }
}
