package com.mc.thinking.java.rongqi17;

public class GenericSort {
    public static <E extends Comparable<E>> void sort(E[] list){
        E currentMin;
        int currentMinIndex;
        for(int i=0; i<list.length-1; i++){
            currentMin = list[i];
            currentMinIndex = i;
            for(int j =i+1;j<list.length; j++){
                if(currentMin.compareTo(list[j]) > 0){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }

    }
    public static void main(String [] args){
        int [] list = {new Integer(1)};
//        sort(list);不可以 必须实现Comparable的类，比如Integer ,Double
    }
}
