package com.mc.wechat.vo;

import lombok.Data;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.Map;

/**
 * @ClassName ApiResult
 * @Author ZhengRongZe
 * 微信返回结果类
 * @Date 2019/3/12 1:29
 **/
@Data
public class ApiResult {
    private static final Log log = Logs.get();
    private Map<String, Object> content;
    private String json;
    private Integer errCode;
    private String errMsg;
    private String errCNMsg;

    public ApiResult(String json) {
        this.json = json;
        this.content = Json.fromJson(Map.class, json);
        this.errCode = (Integer) this.content.get("errcode");
        this.errMsg = (String) this.content.get("errmsg");
        //this.errCNMsg = this.errCode == null ? "请求成功." : _cr.get(String.valueOf(this.errCode));
        this.errCNMsg = this.errCode == null ? "请求成功." : String.valueOf(this.errCode);

        if (log.isInfoEnabled()) {
            log.infof("Wechat api result: %s", json);
            log.infof("%s", this.getErrCNMsg());
        }
    }

    public static ApiResult create(String json) {
        return new ApiResult(json);
    }
    public boolean isSuccess() {
        return (this.errCode == null || this.errCode.intValue() == 0);
    }
}
