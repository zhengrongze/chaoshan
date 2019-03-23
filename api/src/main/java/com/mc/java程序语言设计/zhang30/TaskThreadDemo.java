package com.mc.java程序语言设计.zhang30;

import java.util.Collections;

public class TaskThreadDemo {
    public static void main(String [] args){
        //创建三个线程任务
        PrintChar printChar1 = new PrintChar('a',1000);
        PrintChar printChar2 = new PrintChar('b',100);
        PrintNum printNum = new PrintNum(100);
        Thread thread1 = new Thread(printChar1);
        Thread thread2 = new Thread(printChar2);
        Thread thread3 = new Thread(printNum);
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.setPriority(Thread.MAX_PRIORITY);
    }
}

class PrintChar implements Runnable{
    private char charToPrint;

    private  int times;

    public PrintChar(char charToPrint, int times) {
        this.charToPrint = charToPrint;
        this.times = times;
    }
    @Override
    public void run() {
        for (int i = 0;i < times;i++){
            System.out.println(charToPrint);
        }
    }
}
class PrintNum implements Runnable{
    private int lastNum;

    public PrintNum(int lastNum) {
        this.lastNum = lastNum;
    }

    @Override
     public void run() {
    Thread thread4 = new Thread(new PrintChar('c',40));
    thread4.start();
        for (int i = 0; i < lastNum; i++){
            System.out.println("" + i);
//            Thread.yield();让出时间给其他线程运行
            if(i == 50){
                try {
                    //等待thread4执行结束
                    thread4.join();
//                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /**
            if(i==50){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
             */
        }
    }
}
