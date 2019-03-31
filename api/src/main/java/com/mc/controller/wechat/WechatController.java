package com.mc.controller.wechat;

import com.mc.config.wechat.WechatConfig;
import com.mc.utils.CommonUtil;
import com.mc.utils.Logger;
import com.mc.wechat.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName WechatController
 * @Author ZhengRongZe
 * @Date 2019/3/16 10:28
 **/
@RestController
@Slf4j
@ApiIgnore
public class WechatController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private CommonUtil commonUtil;

    @GetMapping(value = "/wechat")
    public String vilidate(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr){
        String sortString = commonUtil.sort(wechatConfig.getToken(), timestamp, nonce);
        String myString = commonUtil.sha1(sortString);
        if (myString != null && myString != "" && myString.equals(signature)) {
            log.info("签名校验成功");
            return echostr;
        } else {
            log.info("签名校验失败");
            return "";
        }
    }
    @PostMapping(value = "/wechat")
    public String getWechatMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = messageService.sendMessage(request);
        return result;
    }
}
