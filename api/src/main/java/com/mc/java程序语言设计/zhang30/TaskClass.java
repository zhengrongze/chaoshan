package com.mc.java程序语言设计.zhang30;

public class TaskClass implements Runnable {
    private int num;

    public TaskClass(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++){
            System.out.println(i);
            if(i == 10){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String [] args){
        TaskClass taskClass1 = new TaskClass(10011);
        Thread thread1 = new Thread(taskClass1);
        thread1.start();
        TaskClass taskClass2 = new TaskClass(1001);
        Thread thread2 = new Thread(taskClass2);
        thread2.start();
        TaskClass taskClass3 = new TaskClass(1010);
        Thread thread3 = new Thread(taskClass3);
        System.out.println("-------------");
        thread3.start();

    }
}
