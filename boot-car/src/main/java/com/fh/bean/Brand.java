package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 15136
 */
@Data
@TableName("t_brand")
public class Brand {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String brandName;


}
