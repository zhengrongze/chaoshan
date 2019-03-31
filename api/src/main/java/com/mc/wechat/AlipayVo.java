package com.mc.wechat;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AlipayVo
 * @Author ZhengRongZe
 * @Date 2019/2/22 22:22
 **/
@Data
public class AlipayVo implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 订单名称
     */
    private String subject;
    /**
     * 订单编号
     */
    private String out_trade_no;
    /**
     * 订单金额
     */
    private String total_amount;
    /**
     * 销售产品码，与支付宝签约的产品码名称
     */
    private String product_code;
    /**
     * 订单的最晚支付时间,可选操作
     */
    private String timeout_express;
}
