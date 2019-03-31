package com.mc.ali;

import com.alipay.api.AlipayApiException;

import java.util.Map;

public interface AliService {
    String alipagePayOrder(String orderNumber,String productName,String totalAmount,String returnUrl) throws AlipayApiException;
}
