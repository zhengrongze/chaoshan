package com.mc.java程序语言设计.zhang30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 30-4
 */
public class AccountWithoutSync {
    private static Account account  = new Account();
    public static void main(String [] args){

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("start is balance " + account.getBanlance());
        for (int i = 0; i < 100; i++){
            executorService.execute(new AddAPennyTask());
        }
        executorService.shutdown();
        //这里实际上是有100个线程在互相抢夺资源
        while (!executorService.isTerminated()){
        }
        System.out.println("end is balance " + account.getBanlance());
    }
    private static class AddAPennyTask implements Runnable{

        @Override
          public void run() {
                //这里的this所指的是不同的100个线程，所以不能同步执行，改用类名就可以
//                synchronized (this){
                    account.deposit(1);
//
        }
    }
    private  static class Account {
        private static Lock lock = new ReentrantLock();
        private int banlance = 0;

        public int getBanlance() {
            return banlance;
        }

        /**
         * 存钱方法
         * @param account
         * @throws InterruptedException
         */
         public void deposit(int account)  {
             lock.lock();
//             int newBanlance =  banlance + account;
//            Thread.sleep(5);
//            banlance = newBanlance;
//             synchronized (this){
//                 banlance = banlance + account;
//                 System.out.println("余额为" + banlance);
//             }
             try {
                 int newBanlance = banlance + account;
                 Thread.sleep(5);
                 banlance = newBanlance;
             }catch (InterruptedException e){
                 e.printStackTrace();
             }finally {
                 lock.unlock();
             }

        }
    }
}
