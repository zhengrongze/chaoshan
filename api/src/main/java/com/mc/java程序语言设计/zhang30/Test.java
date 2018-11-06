package com.mc.java程序语言设计.zhang30;

public class Test implements Runnable {
    public Test() throws InterruptedException {
        Thread t = new Thread(this);
        t.start();
        t.setPriority(1);
    }

    @Override
    public void run() {
//        try {
//            System.out.println("等待3S");
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("test1 ==================");
    }
    public static void main(String [] args) throws InterruptedException {
        new Test();
        new Test2();
    }
}
class Test2 implements Runnable{
    public Test2() {
        Thread t2 = new Thread(this);
        t2.start();
        t2.setPriority(10);
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++){
            System.out.println("test2  ------------"+i);
            Thread.yield();
        }
    }
}
