package com.mc.thinking.java.jihe13;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
    public static void main(String [] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random();
        for (int i=0; i<10; i++){
            //add()方法一样
            priorityQueue.offer(random.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);
    }
}
