package com.mc.java程序语言设计.zhang24.list;

import java.util.*;

public class Test {

    public static void main(String [] args){
//        List list = new ArrayList();
//        for(int i = 0; i < 100 ; i++){
//            list.add(i+"-");
//        }
//        System.out.println(list.set(0,"wo"));
//
//    MyArrayList<String> myArrayList = new MyArrayList<String>();
//    myArrayList.add("sdadas");
////    myArrayList.add(3,"dsadas");越界
//    myArrayList.add("dasdasdasda");
//    myArrayList.add(myArrayList.size,"dasdasdasd");
//    myArrayList.add(myArrayList.size,"dasdasdasdas");
//        System.out.println(myArrayList.size);
//        for (Object o : myArrayList) {
//            System.out.println(o);
//        }
//        System.out.println(myArrayList.indexOf("dasdasdasda"));
//        System.out.println(myArrayList.indexOf("sdadas"));
       LinkedHashSet set1 = new LinkedHashSet();
       set1.add("New York");
       LinkedHashSet<String> set2 = set1;
        LinkedHashSet<String> set3 = (LinkedHashSet<String>) set1.clone();
        set1.add("Atlanta");
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        LinkedHashMap linkedHashMap = new LinkedHashMap(16,5,true);
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","2");
        linkedHashMap.put("3","3");
        linkedHashMap.put("4","4");
        Iterator it = linkedHashMap.keySet().iterator();
       while (it.hasNext()){
           System.out.println(it.next());
       }
    }

}
