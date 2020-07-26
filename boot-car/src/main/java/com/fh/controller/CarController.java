package com.fh.controller;

import com.fh.bean.Car;
import com.fh.bean.QueryCar;
import com.fh.bean.vo.CarVo;
import com.fh.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 15136
 */
@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService service;

    @RequestMapping("selectCarList")
    public PageInfo<CarVo> selectCarList(QueryCar queryCar){
        PageHelper.startPage(queryCar.getPage(),queryCar.getLimit());

        List<CarVo> list = service.selectCarList(queryCar);

        PageInfo<CarVo> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @RequestMapping("addCar")
    public void addCar(Car car){
        service.addCar(car);
    }

    @RequestMapping("getCarById")
    public Car getCarById(Long id){
        return service.getCarById(id);
    }

    @RequestMapping("updateCar")
    public void updateCar(Car car){
        service.updateCar(car);
    }

    @RequestMapping("deleteCar")
    public void deleteCar(Long id){
        service.deleteCar(id);
    }

    @RequestMapping("deleteAll")
    public void deleteAll(String ids){
        service.deleteAll(ids);
    }
}
