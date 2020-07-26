package com.fh.service;

import com.fh.bean.Brand;

import java.util.List;

/**
 * @author 15136
 */
public interface BrandService {
    /**
     * 查询所有品牌信息
     * @return
     */
    List<Brand> selectBrandList();
}
