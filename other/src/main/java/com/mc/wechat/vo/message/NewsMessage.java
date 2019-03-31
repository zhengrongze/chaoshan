package com.mc.wechat.vo.message;

import com.mc.constant.WechatConstant;
import lombok.Data;

/**
 * @ClassName NewsMessage
 * @Author ZhengRongZe
 * @Date 2019/3/19 9:10
 **/
@Data
public class NewsMessage extends BaseMessage {
    public NewsMessage() {
        this.msgType = WechatConstant.MessMsgType.NEWS;
    }
}
