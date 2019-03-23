package com.mc.java程序语言设计.zhang23;

public class InsertionSort {
    public static void main(String[] args){
        int []  arrays = {2,5,74,9,56,3,4,77};
        insertionSort(arrays);
        for (int i = 0;i < arrays.length; i++){
            System.out.print(arrays[i] + " ");
        }
    }

    public static void insertionSort(int [] arrays){
        for (int i = 1; i < arrays.length; i++){
            int currentElement = arrays[i];
            int k;
            for (k = i - 1; k >= 0 && arrays[k] > currentElement;k--){
                arrays[k + 1] = arrays[k];
            }
            arrays[k + 1] = currentElement;
        }
    }
}
