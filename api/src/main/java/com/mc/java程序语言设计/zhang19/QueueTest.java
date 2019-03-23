package com.mc.java程序语言设计.zhang19;

import java.util.*;

/**
 *
 */
public class QueueTest {
    public static void main(String [] args) {
        Queue<String> queue = new LinkedList<>();
        for (int i=0;i<10;i++){
            queue.offer(i+"");
            System.out.println(queue.peek());
        }
        System.out.println(((LinkedList<String>) queue).peekLast());
        ((LinkedList<String>) queue).removeLast();
        System.out.println(((LinkedList<String>) queue).peekLast());
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("f");
        priorityQueue.offer("d");
        priorityQueue.offer("c");
        priorityQueue.offer("b");
        priorityQueue.offer("a");
        while (priorityQueue.size()>0){
            System.out.print(priorityQueue.remove());
            System.out.println(priorityQueue);
        }
        //倒序插入
        Queue<String> reverQueue = new PriorityQueue<>(4,Collections.reverseOrder());
        reverQueue.offer("a");
        reverQueue.offer("b");
        reverQueue.offer("c");
        reverQueue.offer("d");
        reverQueue.offer("e");
        while (reverQueue.size()>0){
            System.out.print(reverQueue.remove());
            System.out.println(reverQueue);
        }
    }

}
