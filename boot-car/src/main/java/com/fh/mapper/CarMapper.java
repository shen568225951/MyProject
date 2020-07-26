package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Car;
import com.fh.bean.QueryCar;
import com.fh.bean.vo.CarVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 15136
 */
@Mapper
@Repository
public interface CarMapper extends BaseMapper<Car> {
    List<CarVo> selectCarList(QueryCar queryCar);

    void deleteAll(String[] split);
}
