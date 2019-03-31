package com.mc.wechat.service;

import javax.servlet.http.HttpServletRequest;

public interface MessageService {
    String sendMessage(HttpServletRequest request) throws Exception;
}
