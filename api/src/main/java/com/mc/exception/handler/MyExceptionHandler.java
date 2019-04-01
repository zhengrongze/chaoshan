package com.mc.exception.handler;

import com.mc.enums.ExceptionEnum;
import com.mc.exception.OverException;
import com.mc.response.ResponseMessage;
import com.mc.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseMessage exceptionGet(Exception e){
        if(e instanceof OverException){
            OverException MyException = (OverException) e;
//            LOGGER.error("【异常信息】{}",e);
            return ResultUtil.error(MyException.getCode(),MyException.getMessage());
        }

        log.error("【系统异常】{}",e);
        LOGGER.error("【系统异常】{}",e);
        return ResultUtil.error(ExceptionEnum.UNKNOWN_ERROR);
    }
}
