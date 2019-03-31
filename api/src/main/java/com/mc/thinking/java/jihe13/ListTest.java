package com.mc.thinking.java.jihe13;

import java.util.ArrayList;
import java.util.List;
public class ListTest {
    public static void main(String [] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(1,30);
//        System.out.println(list.indexOf(30));

        for (Integer i:list
             ) {
            System.out.println(i);
        }
        Object [] strings = list.<Double>toArray();
        System.out.println(strings[0]);
        System.out.println("-------------------");
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
    }
}
