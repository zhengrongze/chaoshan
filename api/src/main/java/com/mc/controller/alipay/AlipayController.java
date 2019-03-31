package com.mc.controller.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.mc.ali.AliService;
import com.mc.config.ali.AliConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName AlipayController
 * @Author ZhengRongZe
 * @Date 2019/2/22 22:27
 **/
@RestController
@RequestMapping(value = "/alipay")
public class AlipayController{
    private static final String RETURNURL = "http://qifxt7.natappfree.cc/alipay/return";
    private static final String SIGN_TYPE = "RSA2";
    private static final String CHARSET = "UTF-8";

    @Autowired
    private AliService aliService;
    @Autowired
    private AliConfig aliConfig;

    @GetMapping("/pay/{orderNumber}/{totalAmount}/{productName}")
    public String alipayPay(@PathVariable("orderNumber") String orderNumber,
                            @PathVariable("totalAmount") String totalAmount,
                            @PathVariable("productName") String productName) throws AlipayApiException {
        return aliService.alipagePayOrder(orderNumber,productName,totalAmount,RETURNURL);
    }
    @PostMapping(value = "/notify")
    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status) throws AlipayApiException {
        Map<String, String> params = getParamsMap(request);
        // 验证签名
        System.out.println(params);
        boolean signVerified = AlipaySignature.rsaCheckV1(params, aliConfig.getPublicKey(), CHARSET, SIGN_TYPE);
        if (signVerified) {
            System.out.println("去修改订单的状态了");
            return "success";
        } else {
            System.out.println("支付失败了，请返回");
            return "fail";
        }
    }

    /**
     * 支付宝服务器同步通知页面
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no 支付宝交易凭证号
     * @param total_amount 交易状态
     * @return
     * @throws AlipayApiException
     */
    @GetMapping(value = "/return")
    public String alipayReturn(HttpServletRequest request, String out_trade_no,String trade_no,String total_amount) throws AlipayApiException {
        Map<String, String> params = getParamsMap(request);
        System.out.println("支付宝支付结果通知"+params.toString());
        // 验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, aliConfig.getPublicKey(), CHARSET, SIGN_TYPE);

        if (signVerified) {
            return ("成功");
        } else {
            return ("失败");
        }
    }

    private Map<String, String> getParamsMap(HttpServletRequest request) {
        Map<String,String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
                params.put(name, valueStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return params;
    }
}
