package com.mc.response;

import lombok.Data;

/**
 * @ClassName ResponseMessage
 * @Author ZhengRongZe
 * @Date 2018/7/29 10:22
 **/
@Data
public class ResponseMessage<T> {
    private int code;
    private String msg;
    private T data;
}
