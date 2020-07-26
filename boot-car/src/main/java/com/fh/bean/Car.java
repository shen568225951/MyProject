package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 15136
 */
@Data
@TableName("t_car")
public class Car {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String carName;

    private BigDecimal carPrice;

    private Integer isup;

    private Long brandId;

    private String configure;

    private String introduction;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date producedDate;
}
