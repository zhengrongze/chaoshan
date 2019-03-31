package com.mc.wechat.vo.message;

import com.alibaba.fastjson.annotation.JSONField;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

import java.io.Serializable;

/**
 * @ClassName BaseMessage
 * @Author ZhengRongZe
 * @Date 2019/3/16 9:30
 **/
@XStreamAlias("xml")
@Data
public class BaseMessage implements Serializable{
    @XStreamAlias(value = "ToUserName")
    protected String toUserName;
    @XStreamAlias(value = "FromUserName")
    protected String fromUserName;
    @XStreamAlias(value = "CreateTime")
    protected String createTime;
    @XStreamAlias(value = "MsgType")
    protected String msgType;

}
