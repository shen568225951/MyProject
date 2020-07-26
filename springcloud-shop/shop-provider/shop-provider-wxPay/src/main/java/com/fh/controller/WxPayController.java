package com.fh.controller;

import com.fh.WxSDK.MyWXPayConfig;
import com.fh.WxSDK.WXPay;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.goeasy.GoEasy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 15136
 */
@RestController
@RequestMapping("wxPayController")
@CrossOrigin
public class WxPayController {

    /**
     * 微信支付
     * @param wxPrice
     * @param response
     */
    @RequestMapping("createOrder")
    public void createOrder(BigDecimal wxPrice,HttpServletResponse response){
        try {
            //1.生成随机的订单号
            SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss");
            String prefix = sim.format(new Date());  //设置前缀
            String shopId = "2020";     //设置id号
            String orderNum = prefix + shopId; //拼成完整的订单号

            //进行二维码生成
            MyWXPayConfig config = new MyWXPayConfig();

            WXPay wxPay = new WXPay(config);

            Map<String,String> data = new HashMap<>();
            data.put("body", "卢克索酒店赌场--筹码充值"); // 支付中的主题
            data.put("out_trade_no", orderNum); // 订单号
            data.put("device_info", "WEB"); // 设备信息
            data.put("fee_type", "CNY"); // 货币单位：分
            data.put("total_fee", "1"); //  1分
            // 终端ip ,记录ip,可以发现攻击我们的ip并进行 屏蔽
            data.put("spbill_create_ip", "123.12.12.123");
            // 重点：回调地址，用来通知支付结果的地址
            data.put("notify_url", "http://gizsnf.natappfree.cc/wxPayController/weixinPay");
            // 此处指定为扫码支付
            data.put("trade_type", "NATIVE");
            data.put("product_id", shopId);

            Map<String,String> map = wxPay.unifiedOrder(data);
            System.out.println(map.get("code_url"));
            //生成二维码的url
            String url = map.get("code_url");
            qrcode(response,url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码
     * @param response
     * @param url
     * @throws URISyntaxException
     * @throws IOException
     */
    public void qrcode(HttpServletResponse response,String url) throws URISyntaxException, IOException {
        //二维码需要包含的文本内容
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
            System.out.println("创建二维码完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 微信支付的回调接口
     */
    @RequestMapping("weixinPay")
    public void wxpay(){
        System.out.println(123456789);
        GoEasy goEasy = new GoEasy( "rest-hangzhou.goeasy.io","BC-296e696476a64d3aaec0a1657a8d533d");
        goEasy.publish("shen", "Hello, GoEasy!");
    }

}
