package com.mc.exception;

import com.mc.enums.ExceptionEnum;
import lombok.Data;

@Data
public class OverException extends RuntimeException {

    private Integer code;

    private String message;

    public OverException(String message) {
        this.message = message;
    }

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public OverException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public OverException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
