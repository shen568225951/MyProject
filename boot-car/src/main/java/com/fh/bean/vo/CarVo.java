package com.fh.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 15136
 */
@Data
public class CarVo {

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

    private String brandName;
}
