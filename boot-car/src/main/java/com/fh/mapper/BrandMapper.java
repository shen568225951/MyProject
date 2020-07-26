package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 15136
 */
@Mapper
@Repository
public interface BrandMapper extends BaseMapper<Brand> {
}
