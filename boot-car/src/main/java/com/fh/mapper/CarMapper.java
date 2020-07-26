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
    /**
     * 分页+条件查询
     * @param queryCar 条件查询的属性
     * @return 返回查询的数据
     */
    List<CarVo> selectCarList(QueryCar queryCar);

    /**
     * 批量删除
     * @param split 传过来的ids字符串数组
     */
    void deleteAll(String[] split);
}
