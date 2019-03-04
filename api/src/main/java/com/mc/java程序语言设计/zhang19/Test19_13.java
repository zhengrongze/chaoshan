package com.mc.java程序语言设计.zhang19;

import java.util.*;

public class Test19_13 {
    public static void main(String [] args){
        Integer [][] m1 = new Integer[][]{{1,2,3},{4,5,6},{1,1,1}};
        Integer [][] m2 = new Integer[][]{{1,1,1},{2,2,2},{0,0,0}};
        Test19_11 test19_11 = new Test19_11();
        Test19_10.printResult(m1,m2,test19_11.addMatrix(m1,m2),'+');
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("red");
        list1.add("green");
        list1.add("yellow");
        list2.add("c");
        list2.add("a");

//        list2.add("yellow");
        list1.remove(list2);
        System.out.println(list1);
        System.out.println(list2);
        Collections.copy(list1,list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list1.get(0).hashCode());
        System.out.println(list1.get(1).hashCode());
        System.out.println(list1.get(2).hashCode());
        System.out.println(Collections.max(list1));
        System.out.println(Collections.min(list1));

    }
}
