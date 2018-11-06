package com.mc.thinking.java.jihe13;

import java.util.*;

public class SetTest {
    public static void main(String [] args){
        Random random = new Random();
        //可排序
//        SortedSet set = new TreeSet();
        Set<Integer> set = new HashSet();
        for(int i=0;i<100;i++){
            set.add(random.nextInt(100));
        }
        System.out.println(set);
        for (int j = 0;j<3;j++){
            //添加参数生成的随机数是伪随机数，没有参数的构造器是以当前时间作为种子随机性更强
            Random random2 = new Random(10);
            Set<Integer> set2 = new HashSet();
            for(int i=0;i<20;i++){
                set2.add(random2.nextInt(100));
            }
            System.out.println(set2);
        }

    }
}
