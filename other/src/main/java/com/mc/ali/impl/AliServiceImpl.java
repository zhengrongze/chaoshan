package com.mc.ali.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.mc.ali.AliService;
import com.mc.config.ali.AliConfig;
import com.mc.utils.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName AliServceImpl
 * @Author ZhengRongZe
 * @Date 2019/2/25 13:47
 **/
@Service
public class AliServiceImpl implements AliService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private AliConfig aliConfig;

    private String signType = "RSA2";
    private String charset = "UTF-8";



    /**
     *
     * @param orderNumber 订单号
     * @param productName 商品名称
     * @param totalAmount 总价格
     * @param returnUrl 支付成功后返回的链接
     * @return
     */
    public String alipagePayOrder(String orderNumber,String productName,String totalAmount,String returnUrl) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliConfig.getGatewayUrl(),aliConfig.getAppId(),aliConfig.getMerchantPrivateKey(),"json",charset,aliConfig.getPublicKey(),signType);
        AlipayTradePagePayRequest pagePayRequest = new AlipayTradePagePayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setOutTradeNo(orderNumber);
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setSubject(productName);
        model.setTotalAmount(totalAmount);
        pagePayRequest.setNotifyUrl("http://qifxt7.natappfree.cc/alipay/notify");
        pagePayRequest.setReturnUrl(returnUrl);
        pagePayRequest.setBizModel(model);
            //添加日志消息
            logger.info("参数内容为"+model);
            AlipayTradePagePayResponse result = alipayClient.pageExecute(pagePayRequest);
            if(result.isSuccess()){
                logger.info("拉取支付成功");
            }else {
                logger.info("拉取支付失败");
            }
            return result.getBody();
    }
}
