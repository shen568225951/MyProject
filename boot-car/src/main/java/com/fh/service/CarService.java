package com.fh.service;

import com.fh.bean.Car;
import com.fh.bean.QueryCar;
import com.fh.bean.vo.CarVo;

import java.util.List;

/**
 * @author 15136
 */
public interface CarService {
    List<CarVo> selectCarList(QueryCar queryCar);

    void addCar(Car car);

    Car getCarById(Long id);

    void updateCar(Car car);

    void deleteCar(Long id);

    void deleteAll(String ids);
}
