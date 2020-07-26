package com.fh.service.impl;

import com.fh.mapper.TProductMapper;
import com.fh.model.TProduct;
import com.fh.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TProductServiceImpl implements TProductService {

    @Autowired
    private TProductMapper productMapper;

    /**
     * 向商品表中新增一条数据
     * @param tproduct
     */
    @Override
    public void addProduct(TProduct tproduct) {
        productMapper.insert(tproduct);
    }

    /**
     * 查询所有的商品信息
     * @return
     */
    @Override
    public List<TProduct> selectProductList() {
        return productMapper.selectProductList();
    }

    /**
     * 该方法时根据商品的Id 查询商品信息 用于商品信息展示页面
     * @param pid
     * @return
     */
    @Override
    public TProduct selectProductInfoByPid(Long pid) {
        return productMapper.selectProductInfoByPid(pid);
    }

    /**
     * 根据商品的 pid 批量查询商品信息
     * @param pids
     * @return
     */
    @Override
    public List<TProduct> selectProductsByPids(List<Long> pids) {
        return productMapper.selectProductsByPids(pids);
    }
}
