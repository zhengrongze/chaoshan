package com.mc.thinking.java.exception;
class SimleException extends Exception{
    private Integer code;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SimleException() {
    }

    public SimleException(Integer code,String msg) {
        this.msg = msg;
        this.code = code;
    }

}
public class InheritingExceptions {

    public void f() throws SimleException{
        System.out.println("f()抛出了一个异常");
        throw new SimleException(400,"这个一个致命错误");
    }
    public static void main(String [] args){
        InheritingExceptions inheritingExceptions = new InheritingExceptions();
        try {
            inheritingExceptions.f();
        }catch (SimleException e){
            e.printStackTrace();
            System.out.println("Caught it! " + e.getCode() +","+ e.getMsg());
        }finally {
            System.out.println("finally 语句 execute");
        }
    }
}
