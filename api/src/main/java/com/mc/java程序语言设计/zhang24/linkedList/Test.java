package com.mc.java程序语言设计.zhang24.linkedList;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String [] args){
        LinkedList<Object> linkedList = new LinkedList<>();


        linkedList.addFirst(111);
        linkedList.addFirst(222);
        System.out.println(linkedList.toString());

    }
}
