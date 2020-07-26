package com.fh.service.impl;

import com.alibaba.fastjson.JSON;
import com.fh.mapper.TOrderMapper;
import com.fh.model.TOrder;
import com.fh.model.TOrderinfo;
import com.fh.model.TProduct;
import com.fh.model.dto.CreateOrderDto;
import com.fh.model.dto.OrderDto;
import com.fh.model.dto.ProductDto;
import com.fh.model.vo.OrderVo;
import com.fh.service.IOrderService;
import com.fh.service.OrderInfoFeignService;
import com.fh.service.ProductFeignService;
import com.fh.utils.DateUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 15136
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignService productFeignService;

    @Autowired
    private OrderInfoFeignService orderInfoFeignService;

    /**
     * 该方法是 通过orderVo中的数据 分别向订单表和订单详情表 中添加数据
     * @param orderVo
     */
    @Override
    public void addOrder(OrderVo orderVo) {
        //获取OrderVO 中的数据
        TOrder tOrder = orderVo.gettOrder();

        List<TProduct> productList = orderVo.getProductList();

        //向订单表中添加数据
        orderMapper.insert(tOrder);

        //组装订单详情表
        List<TOrderinfo> orderinfoList = new ArrayList<>();
        //获取订单ID

        for (int i = 0; i < productList.size(); i++) {
            TOrderinfo orderinfo = new TOrderinfo();
            //获取订单ID
            orderinfo.setOrderId(tOrder.getOrderId());
            //设置商品的Id
            orderinfo.setProId(orderVo.getPids().get(i));
            //设置商品数量
            orderinfo.setCounts(orderVo.getCounts().get(i));
            //将商品详情放入集合中
            orderinfoList.add(orderinfo);
        }

        //将订单详情数据传给订单详情的service
            orderInfoFeignService.addOrderInfo(orderinfoList);
            //orderInfoService.addOrderInfo(orderinfoList);
            //restTemplate.getForObject("http://shop-provider-orderInfo/orderInfoController/addOrderInfo?orderInfoList="+orderinfoList,null);
    }



    /**
     * 该方法是向 订单表和订单详情表中添加数据
     * @param orderDto 这个类是用来接收前端传递过来的参数
     */
    @Override
    public void addOrder(OrderDto orderDto,HttpServletResponse response) {
        //New一个VO的实体类
        OrderVo orderVo = new OrderVo();
        //New一个 order对象
        TOrder tOrder = new TOrder();
        //给Order对象赋值
        tOrder.setUpdatededTime(new Date());

        tOrder.setCreatedTime(new Date());

        tOrder.setOrderAddr(orderDto.getOrderAddr());

        tOrder.setUserId(orderDto.getUserId());

        tOrder.setOrderPrice(orderDto.getOrderPrice());

        tOrder.setOrderTel(orderDto.getOrderTel());

        tOrder.setOrderUser(orderDto.getOrderUser());

        tOrder.setOrderFlag((short) 1);

        tOrder.setOrderId(DateUtil.createIdByDate());

        //将Pids 和pcounts 放入VO类中
        orderVo.setCounts(orderDto.getPcount());
        orderVo.setPids(orderDto.getPids());
        //将赋值完的 订单order 放入 VO类中
        orderVo.settOrder(tOrder);

        //根据商品 pids 批量查询商品数据并放入VO类中
        /*String result3 = restTemplate.getForObject("http://shop-provider-product/productController/selectProductsByPids?pids="+orderDto.getPids(),String.class);
        List<TProduct> tProductList = JSON.parseArray(result3,TProduct.class);*/

        List<TProduct> tProductList = productFeignService.selectProductsByPids(orderDto.getPids());

        //将查询出来的商品数据放入VO类中
        orderVo.setProductList(tProductList);

        //调用订单新增和订单详情新增的方法
        addOrder(orderVo);


    }

    /**
     * 我的订单 如何实现
     * 该方法是用来根据用户ID查询该用户的订单的所有数据
     * 创建的对象 有 一个存放 订单DTO类 的list  一个存放 商品DTO类 的list集合 一个商品类的实例  一个订单DTO类的实例
     * 步骤 1.首先根据传递的用户Id查询出来  订单表的所有数据，并遍历循环该list
     *     2.根据订单表中的 订单Id 去订单详情表中 查询商品的的Id list集合<订单详情类> 并遍历循环 list
     *     3.商品DTO类中 存放的有商品的数据和 订单的数量  实例化一个list< 商品DTO类 >  用存放 根据订单Id 查询到的 商品的集合
     *     4.实例化一个商品类  将查询出来的商品信息赋值给 商品DTO类  --》并添加到 list< 商品DTO类 > 集合
     *     5.实例化一个 订单DTO类 并将查询出来的  order对象 赋值给 orderDTO类  将赋值过后的 orderDTO类 放入 list< 订单DTO类 > 中
     *     6.至此，前端页面 我的订单  页面所需要的数据查询完毕 将查询出来的  list数据集合 返回给前端
     *
     * @param userId 前端传递过来的用户ID
     * @return 将查询出来的数据返回给前端并展示出来
     */
    @Override
    public List<CreateOrderDto> getOrderList(Long userId) {
        //1.new 一个 DTO实例
        List<CreateOrderDto> createOrderDtoList = new ArrayList<>();

        //2.根据用户ID查询所有的订单详情数据
        List<TOrder> tOrderList = orderMapper.selectOrderListByUserId(userId);

        //3.遍历循环 (JDK1.8特性 lambdas表达式 -- 箭头函数)
        tOrderList.forEach(order ->{
            //3.1根据订单Id去获取订单详情表中的 商品ID
/*            String result = restTemplate.getForObject("http://shop-provider-product/orderInfoController/selectOrderInfoListByOrderId?orderId="+order.getOrderId(),String.class);
            List<TOrderinfo> tOrderinfoList = JSON.parseArray(result,TOrderinfo.class);*/

            List<TOrderinfo> tOrderinfoList = orderInfoFeignService.selectOrderInfoListByOrderId(order.getOrderId());


            //根据商品ID查询商品表的数据
            //3.2new 一个list集合存放查询的数据
            List<ProductDto> productDtoList = new ArrayList<>();
            //3.3遍历循环订单详情LIst  aa为变量名 代表list中的每一个对象
            tOrderinfoList.forEach(aa ->{
                //3.4封装DTO信息
                ProductDto productDto = new ProductDto();
                //3.5根据查询出来的商品ID 查询商品的信息
                /*String result2 = restTemplate.getForObject("http://shop-provider-product/productController/selectProductInfoByPid?pid="+aa.getProId(),String.class);
                TProduct tProduct = JSON.parseObject(result2,TProduct.class);*/

                TProduct tProduct = productFeignService.selectProductInfoByPid(aa.getProId());

                //3.6将查询出来的数据赋值给商品DTO类
                productDto.setPimg(tProduct.getPimg());
                productDto.setPname(tProduct.getPname());
                productDto.setPrice(tProduct.getPrice());
                productDto.setPcount(aa.getCounts());

                //3.7将组装的商品DTO信息放入商品DTO集合中
                productDtoList.add(productDto);
            });

            //3.8封装 OrderDTO类
            CreateOrderDto createOrderDto = new CreateOrderDto();

            createOrderDto.setCreateTime(order.getCreatedTime());
            createOrderDto.setOrderNum(order.getOrderId());
            createOrderDto.setTotalPrice(order.getOrderPrice());

            //4 将商品信息集合放入DTO类中
            createOrderDto.setProductDtoList(productDtoList);
            //5 将订单信息放入DTO类中
            createOrderDtoList.add(createOrderDto);

        });

        return createOrderDtoList;
    }

}
