package com.mc.sms;

import lombok.Data;

@Data
public class SmsRequest {
    private String phoneNumbers;//短信签名名称
    private String signName;//短信签名名称
    private String templateCode;//短信模板ID
}
