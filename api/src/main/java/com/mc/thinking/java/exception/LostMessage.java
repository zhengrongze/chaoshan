package com.mc.thinking.java.exception;

/**
 * ，VeryImportantExecption被HoHumException取代  修改为HoHumException被DisanException取代
 *
 */
class VeryImportantExecption extends Exception{
    @Override
    public String toString() {
        return "VeryImportantExecption{}";
    }
}
class HoHumException extends Exception{
    @Override
    public String toString() {
        return "HoHumException{}";
    }
}
class DisanException extends Exception{
    @Override
    public String toString() {
        return "DisanException{}";
    }
}
public class LostMessage {
    void f() throws VeryImportantExecption{
        throw new VeryImportantExecption();
    }
    void dispose() throws  HoHumException{
        throw new HoHumException();
    }
    void disancheng() throws DisanException{
        throw new DisanException();
    }
    public static void main(String [] args) {
        LostMessage lm = new LostMessage();
        try {
        try {
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } finally{
            lm.disancheng();
            }
        }catch(Exception e){
        System.out.println(e);
    }
    }
}
