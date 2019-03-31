package com.mc.wechat.vo.message;

import com.mc.constant.WechatConstant;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @ClassName TextMessage
 * @Author ZhengRongZe
 * @Date 2019/3/16 9:33
 **/
@Data
public class TextMessage extends BaseMessage {
    @XStreamAlias(value = "Content")
    private String content;
    public TextMessage() {
        this.msgType = WechatConstant.MessMsgType.TEXT;
    }
}
