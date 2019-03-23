package com.mc.utils;

import com.mc.exception.OverException;

public class AssertUtil {
    public static void isTrue(Boolean flag,String message){
        if(flag){
            throw new OverException(message);
        }
    }
}
