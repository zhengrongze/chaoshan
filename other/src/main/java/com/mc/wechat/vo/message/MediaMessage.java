package com.mc.wechat.vo.message;

import com.mc.constant.WechatConstant;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @ClassName MediaMessage
 * @Author ZhengRongZe
 * @Date 2019/3/19 8:40
 **/
@Data
public class MediaMessage extends BaseMessage{
    @XStreamAlias("MediaId")
    private String mediaId;

    public MediaMessage() {
        this.msgType = WechatConstant.MessMsgType.MEDIA;
    }
}
