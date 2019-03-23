package com.mc.thinking.java.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test10 {
    private static void f() throws LoggingException {
        try {
            g();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            throw new LoggingException();
        }
    }
    private static void g() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }
    public static void main(String [] args) throws LoggingException {
        f();
    }
}
