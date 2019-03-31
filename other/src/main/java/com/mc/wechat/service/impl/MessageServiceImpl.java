package com.mc.wechat.service.impl;

import com.mc.config.wechat.WechatConfig;
import com.mc.constant.WechatConstant;
import com.mc.utils.CommonUtil;
import com.mc.wechat.service.MessageService;
import com.mc.wechat.vo.message.MediaMessage;
import com.mc.wechat.vo.message.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName MessageServiceImpl
 * @Author ZhengRongZe
 * @Date 2019/3/18 16:54
 **/
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private CommonUtil commonUtil;

    public String sendMessage(HttpServletRequest request) throws Exception {
        String resultMessage = null;
        Map<String, String> map = commonUtil.parseXml(request);
        String msgType = map.get("MsgType");
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        return sendTextMessage(toUserName,fromUserName);
    }

    /**
     * 普通文本
     * @param toUserName
     * @param fromUserName
     * @return
     */
    private String sendTextMessage(String toUserName,String fromUserName){
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setContent("你好啊");
        textMessage.setCreateTime(new Date().toString());
        return commonUtil.textMessageToXml(textMessage);
    }
    /**
     * 图片消息
     * @param toUserName
     * @param fromUserName
     * @return
     */
    private String sendMediaMessage(String toUserName,String fromUserName){
        MediaMessage mediaMessage = new MediaMessage();
        mediaMessage.setToUserName(fromUserName);
        mediaMessage.setFromUserName(toUserName);
        mediaMessage.setCreateTime(new Date().toString());
        mediaMessage.setMediaId("");
        return commonUtil.MediaMessageToXml(mediaMessage);
    }
}
