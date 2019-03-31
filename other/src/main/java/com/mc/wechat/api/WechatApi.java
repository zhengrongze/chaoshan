package com.mc.wechat.api;

import com.mc.wechat.vo.MenuApi;

public interface WechatApi extends MenuApi {
    String wechatApi = "https://api.weixin.qq.com";
    String cgi_bin = wechatApi + "/cgi-bin";
}
