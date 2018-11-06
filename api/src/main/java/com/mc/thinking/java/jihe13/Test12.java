package com.mc.thinking.java.jihe13;

import java.util.*;

/**
 * 构建两个容器，往一个容器中添加数据，再放入到另外一个容器中将元素倒序输出
 */
public class Test12 {
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=0;i<10;i++){
            list1.add(i);
        }
        ListIterator<Integer> it = list1.listIterator();
//        for (it = list1.listIterator();it.hasNext();) {
//            it.next();
//        }
//        for (;it.hasPrevious();) {
//            System.out.println(it.previous());
//        }
        Collections.reverse(list1);
        list2.addAll(list1);
        for (Integer i : list2) {
            System.out.println(i);
        }
    }
}
