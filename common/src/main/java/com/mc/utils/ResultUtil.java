package com.mc.utils;

import com.mc.enums.ExceptionEnum;
import com.mc.response.ResponseMessage;

/**
 * @ClassName ResultUtil
 * @Author ZhengRongZe
 * @Date 2018/7/29 10:30
 **/
public class ResultUtil {
    /**
     *操作成功返回对象
     * @param object
     * @return
     */
    public static ResponseMessage success(Object object){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(ExceptionEnum.SUCCESS.getCode());
        responseMessage.setMsg(ExceptionEnum.SUCCESS.getMsg());
        responseMessage.setData(object);
        return responseMessage;
    }

    /**
     * 操作成功不返回对象
     * @return
     */
    public static ResponseMessage success(){
        return success(null);
    }

    /**
     * 操作失败
     * @param code
     * @param msg
     * @return
     */
    public static ResponseMessage error(int code,String msg){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(code);
        responseMessage.setMsg(msg);
        return responseMessage;
    }
    /**
     * 操作失败返回消息，对error的重载
     * @param exceptionEnum
     * @return
     */
    public static ResponseMessage error(ExceptionEnum exceptionEnum){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(exceptionEnum.getCode());
        responseMessage.setMsg(exceptionEnum.getMsg());
        return responseMessage;
    }
}
