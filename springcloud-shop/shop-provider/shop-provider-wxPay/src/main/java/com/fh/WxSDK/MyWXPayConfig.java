package com.fh.WxSDK;

import java.io.InputStream;

/**
 * @author 15136
 */
public class MyWXPayConfig extends WXPayConfig {
    // 微信公众号的ID
    @Override
    String getAppID() {
        return "wxa1e44e130a9a8eee";
    }

    // 微信支付商户号
    @Override
    String getMchID() {
        return  "1507758211";
    }

    @Override
    String getKey() {
        return "feihujiaoyu12345678yuxiaoyang123";
    }

    @Override
    InputStream getCertStream() {
        return null;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        MyWXPayDomain myWXPayDomain = new MyWXPayDomain();
        return myWXPayDomain;
    }
}
