package com.mc.wechat.vo.message;

import com.mc.constant.WechatConstant;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @ClassName VoiceMeaage
 * @Author ZhengRongZe
 * @Date 2019/3/19 8:59
 **/
@Data
public class VoiceMessage extends BaseMessage{
    @XStreamAlias("MediaId")
    private String mediaId;

    public VoiceMessage() {
        this.msgType = WechatConstant.MessMsgType.VOICE;
    }
}
