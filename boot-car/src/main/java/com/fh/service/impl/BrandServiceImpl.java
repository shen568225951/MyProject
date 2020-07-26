package com.fh.service.impl;

import com.fh.bean.Brand;
import com.fh.mapper.BrandMapper;
import com.fh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 15136
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper mapper;

    @Override
    public List<Brand> selectBrandList() {
        return mapper.selectList(null);
    }
}
