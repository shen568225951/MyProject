package com.fh.controller;

import com.fh.model.vo.CartVo;
import com.fh.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 15136
 */
@RestController
@RequestMapping("tCartController")
@CrossOrigin
public class TCartController {

    @Autowired
    private ICartService iCartService;



    /**
     * //根据 所传参数  连表查询购物车列表
     * @param userId 用户ID
     * @param pid 商品ID
     * @param count 商品数量
     * @return
     */
    @RequestMapping("addCart")
    public List<CartVo> addCart(Long userId,Long pid,Long count){
        return iCartService.addCart(userId,pid,count);
    }

}
