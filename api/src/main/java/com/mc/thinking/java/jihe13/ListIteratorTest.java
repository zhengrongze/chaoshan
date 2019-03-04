package com.mc.thinking.java.jihe13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String [] args) {
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<100000;i++){
            list.add(i);
        }
        
        ListIterator<Integer> iterator = list.listIterator();
        long start = System.currentTimeMillis();
//        while (iterator.hasNext()){
//            Integer i = iterator.next();
//        }
        for(int i=0;i<list.size();i++){

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        long start1 = System.currentTimeMillis();
        Iterator<Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            Integer i = iterator1.next();
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }
}
