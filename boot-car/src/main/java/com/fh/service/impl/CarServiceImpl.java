package com.fh.service.impl;

import com.fh.bean.Car;
import com.fh.bean.QueryCar;
import com.fh.bean.vo.CarVo;
import com.fh.mapper.CarMapper;
import com.fh.service.CarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author 15136
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<CarVo> selectCarList(QueryCar queryCar) {
        if (StringUtils.isNotBlank(queryCar.getQueryConfigure())){
            queryCar.setConfigureList(Arrays.asList(queryCar.getQueryConfigure().split(",")));
        }
        return mapper.selectCarList(queryCar);
    }

    @Override
    public void addCar(Car car) {
        mapper.insert(car);
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCarById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public void updateCar(Car car) {
        mapper.updateById(car);
    }

    @Override
    public void deleteCar(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public void deleteAll(String ids) {
        String[] split = ids.split(",");
        mapper.deleteAll(split);
    }
}
