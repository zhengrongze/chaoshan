package com.mc.wechat.api;

import com.alibaba.fastjson.JSONObject;
import com.mc.config.wechat.WechatConfig;
import com.mc.constant.WechatConstant;
import com.mc.constant.WechatUrlConstant;
import com.mc.redis.client.ICache;
import com.mc.utils.HttpClientUtil;
import com.mc.utils.HttpTool;
import com.mc.wechat.vo.menu.Menu;
import com.mc.wechat.vo.ApiResult;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName WechatApiImpl
 * @Author ZhengRongZe
 * @Date 2019/3/11 21:43
 **/
@Service
public class WechatApiImpl implements WechatApi {
    private static final Log log = Logs.get();
    static int RETRY_COUNT = 3;

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private ICache iCache;

    public List<Menu> getMenu() {
        return null;
    }

    public boolean createMenu(List<Menu> menus) {
        String url = mergeCgiBinUrl(create_menu + getAsseccToken());
        Map<String,Object> body = new HashMap<String, Object>();
        body.put("button",menus);
        String data = Json.toJson(body, JsonFormat.compact());
        ApiResult result = null;
        for (int i = 0; i < RETRY_COUNT; i++){
            result = ApiResult.create(HttpTool.post(url,data));
            if(result.isSuccess()){
                return true;
            }

            log.errorf("Create mp[%s] custom menu failed. There try %d items.",
                    i + 1);
        }

        throw org.nutz.lang.Lang.wrapThrow(new Exception(result.getJson()));

    }

    public boolean delMenu() {
        return false;
    }


    public  String getAsseccToken(){
        String accessToken = iCache.get(WechatConstant.WECHAT_ACCESS_TOKEN);
        if(StringUtils.isNotEmpty(accessToken)){
            return accessToken;
        }
        //TODO 到时候把这部分抽取出来称为一个独立的方法进行URL拼接
        StringBuffer formatUrl = new StringBuffer(WechatUrlConstant.ACCESS_TOKEN);
        formatUrl.append("?grant_type=client_credential");
        formatUrl.append("&appid=").append(wechatConfig.getAppId());
        formatUrl.append("&secret=").append(wechatConfig.getAppSecret());
        String json = HttpClientUtil.sendGetRequest(formatUrl.toString(),null);
        accessToken = JSONObject.parseObject(json).getString("access_token");
        Long expires_in = JSONObject.parseObject(json).getLong("expires_in");
        iCache.put(WechatConstant.WECHAT_ACCESS_TOKEN,accessToken,expires_in-200, TimeUnit.SECONDS);
        return accessToken;
    }
    private String mergeCgiBinUrl(String url, Object... values) {
        if (!Lang.isEmpty(values)) {
            return cgi_bin + String.format(url, values);
        }
        return cgi_bin + url;
    }
}
