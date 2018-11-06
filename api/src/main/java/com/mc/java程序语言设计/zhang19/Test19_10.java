package com.mc.java程序语言设计.zhang19;

public abstract class Test19_10<E extends Number> {
    protected abstract E add(E o1,E o2);
    protected abstract E multiply(E o1,E o2);
    protected abstract E zero();
    public E [][] addMatrix(E [][] martix1,E [][] martix2){
        //如果1的长度不等于2的长度或者1的行的长度不等于2的行长度
        if((martix1.length != martix2.length) || (martix1[0].length != martix2[0].length)){
            throw new RuntimeException("The matrices do not have the same size");
        }
        E [][] result = (E[][]) new Number[martix1.length][martix1[0].length];
        for(int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                result[i][j] = add(martix1[i][j],martix2[i][j]);
            }
        }
        return result;
    }
    public E [][] multiplyMartix(E [][] martix1,E [][] martix2){
        if(martix1.length != martix2.length){
            throw new RuntimeException("The matrices do not have the same size");
        }
        E [][] result = (E[][]) new Number[martix1.length][martix1[0].length];
        for(int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){
                result[i][j] = zero();
                for (int k = 0; k< martix1[0].length; k++){
                    result[i][j] = add(result[i][j],multiply(martix1[i][k],martix2[k][j]));
                }
            }
        }
        return result;
    }
    public static void printResult(Number[][] m1,Number[][] m2,Number[][] m3,char op){
        for (int i = 0; i < m1.length; i++){
            for (int j = 0; j < m1[0].length; j++){
                System.out.print(" " + m1[i][j]);
            }
            if(i == m1.length / 2){
                System.out.print(" " + op + " ");
            }else {
                System.out.print("    ");
            }
            for (int j = 0; j < m2.length; j++){
                System.out.print(" " + m2[i][j]);
            }
            if(i == m1.length / 2){
                System.out.print(" = ");
            }else {
                System.out.print("    ");
            }
            for (int j = 0; j < m3.length; j++){
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }

    }
}
