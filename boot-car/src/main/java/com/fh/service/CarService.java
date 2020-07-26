package com.fh.service;

import com.fh.bean.Car;
import com.fh.bean.QueryCar;
import com.fh.bean.vo.CarVo;

import java.util.List;

/**
 * @author 15136
 */
public interface CarService {
    /**
     * 分页+条件查询
     * @param queryCar
     * @return
     */
    List<CarVo> selectCarList(QueryCar queryCar);

    /**
     * 新增
     * @param car
     */
    void addCar(Car car);

    /**
     * 回显
     * @param id
     * @return
     */
    Car getCarById(Long id);

    /**
     * 修改
     * @param car
     */
    void updateCar(Car car);

    /**
     * 删除
     * @param id
     */
    void deleteCar(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteAll(String ids);
}
