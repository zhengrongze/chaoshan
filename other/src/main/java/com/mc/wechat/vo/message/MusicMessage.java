package com.mc.wechat.vo.message;

import com.mc.constant.WechatConstant;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @ClassName MusicMessage
 * @Author ZhengRongZe
 * @Date 2019/3/19 9:06
 **/
@Data
public class MusicMessage extends BaseMessage {
    /**
     * 音乐标题
     */
    @XStreamAlias("Title")
    private String title;
    /**
     * 音乐描述
     */
    @XStreamAlias("Description")
    private String description;
    /**
     * 	音乐链接
     */
    @XStreamAlias("MusicURL")
    private String musicUrl;
    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    @XStreamAlias("HQMusicUrl")
    private String hqMusicUrl;
    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    public MusicMessage() {
        this.msgType = WechatConstant.MessMsgType.MUSIC;
    }
}
