package com.mc.java程序语言设计.zhang23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;

public class HeapSort {
    public static void main(String[] args) throws Exception {
        Integer [] list = {-44,-5,-3,1,-4,2,2,3,4,6,8,44};
        heapSort(list);
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }







        
    }
    public static<E extends Comparable<E>> void heapSort(E[] list) throws Exception {
        Heap<E> heap = new Heap<>();
        for (Object o : list) {
            heap.add((E) o);
        }
        for (int i = list.length -1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
