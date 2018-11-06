package com.mc.thinking.java.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ArrayIndexOutOfBoundsException extends Exception{
    private static Logger logger = Logger.getLogger("ArrayIndexOutOfBoundsException");
    public ArrayIndexOutOfBoundsException() {
        StringWriter stringWriter = new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }

    public static void main(String [] args){
        try {
            int [] ints = {1,2,3,4};
            System.out.println(ints[4]);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
