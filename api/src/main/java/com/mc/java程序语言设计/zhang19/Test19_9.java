package com.mc.java程序语言设计.zhang19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test19_9 {
    public static void main(String [] args){
        List<String> l1 = new ArrayList<>();
        List<Object> l2 = new ArrayList<>();
//        add(l1,l2);会报错，除非add(List<？ extends T> list1,List<T> list2)String extends Object 这样就没问题
    }
    private static <T> void add(List<T> list1,List<T> list2){
        list2.addAll(list1);
    }
}
