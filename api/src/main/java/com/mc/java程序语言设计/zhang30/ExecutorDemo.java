package com.mc.java程序语言设计.zhang30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String [] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);
//        ExecutorService executor = Executors.newCachedThreadPool();没有什么变化
        executor.execute(new PrintChar('a',100));
        executor.execute(new PrintChar('b',100));
        executor.execute(new PrintNum(100));
        executor.shutdown();
    }
}
