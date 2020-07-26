package com.fh.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 15136
 */
@Data
public class QueryCar {

    private String queryName;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private Integer queryIsup;

    private Long queryBrandId;

    private String queryConfigure;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date minTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date maxTime;

    private List configureList;

    private Integer page;

    private Integer limit;


}
