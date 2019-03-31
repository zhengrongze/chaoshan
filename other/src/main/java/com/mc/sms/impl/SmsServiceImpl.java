package com.mc.sms.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.mc.sms.SmsService;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService{
    public void sendSms(String phone) {
        DefaultProfile profile = DefaultProfile.getProfile();
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers",phone);
    }
}
