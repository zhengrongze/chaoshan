package com.mc.thinking.java.jihe13;

import java.util.*;

/**
 * 练习14
 */
public class LinkedListTest {
    public static void main(String [] args){
        List<Integer> list = new LinkedList<>();
        Integer [] x = {1,2,3,4,5,6,7};

//        ((LinkedList<Integer>) list).getFirst();
        addMiddle(list,x);
    }
    static void addMiddle(List<Integer> list,Integer [] array){
        for (Integer a : array){
            //获取游标
            Integer index = list.size()/2;
            ListIterator<Integer> it = list.listIterator(index);
            //往游标的位置添加
            it.add(a);
            System.out.println(list);
        }
    }
}
