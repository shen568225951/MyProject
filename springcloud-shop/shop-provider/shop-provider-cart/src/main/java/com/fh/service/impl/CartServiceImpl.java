package com.fh.service.impl;

import com.fh.mapper.TCartMapper;
import com.fh.model.TCart;
import com.fh.model.vo.CartVo;
import com.fh.service.ICartService;
import com.fh.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 15136
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private TCartMapper tCartMapper;

    //查询购物车信息
    @Override
    public List<CartVo> addCart(Long userId, Long pid, Long count) {

        //1.获取当前用户的购物车信息
        List<TCart> tCartList = tCartMapper.selectCartByUserId(userId);
        //判断数量不为空
        if (count != null){
            //2.判断当前商品是否在购物车中
            //2-1.如果商品在购物车中，就修改购物车中商品的数量
            boolean flag = true;
            for (TCart tCart : tCartList) {
                if(tCart.getPid().equals(pid)){
                    tCart.setPcount(tCart.getPcount()+count);
                    tCartMapper.updateByPrimaryKey(tCart);
                    flag = false;
                }
            }
            //2-2 如果商品不在购物车中，就向购物车中新增一条数据
            if (flag){
                // New一个购物车对象，并将商品数量，用户id，商品ID 赋值给该对象
                TCart tCart = new TCart();
                tCart.setPcount(count);
                tCart.setUserId(userId);
                tCart.setPid(pid);
                tCart.setCartId(DateUtil.createIdByDate());
                tCartMapper.insert(tCart);
            }
        }

        //3 获取更新过后的购物车信息
        List<CartVo> cartVoList = tCartMapper.selectCartVoByUserId(userId);

        return cartVoList;
    }
}
