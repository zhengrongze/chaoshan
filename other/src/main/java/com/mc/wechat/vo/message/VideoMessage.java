package com.mc.wechat.vo.message;

import com.mc.constant.WechatConstant;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @ClassName VideoMessage
 * @Author ZhengRongZe
 * @Date 2019/3/19 9:04
 **/
@Data
public class VideoMessage extends BaseMessage{
    @XStreamAlias("MediaId")
    private String mediaId;
    /**
     * 视频消息的标题
     */
    @XStreamAlias("Title")
    private String title;
    /**
     * 视频消息的描述
     */
    @XStreamAlias("Description")
    private String description;

    public VideoMessage() {
        this.msgType = WechatConstant.MessMsgType.VIDEO;
    }
}
