package com.mc.thinking.java.exception;

public class NullException {
    private static ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;

    public static void main(String [] args) {
       try {
           getInstance().toString();
       }catch (Exception e){
           e.printStackTrace();
       }

    }
    private static ArrayIndexOutOfBoundsException getInstance(){

        return arrayIndexOutOfBoundsException;
    }
}
