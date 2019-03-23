package com.mc.set;

import sun.nio.cs.Surrogate;
import sun.rmi.rmic.Generator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestArray {
    public static void main(String[] args){
        int [] ints = {1,2,3,4,5};
        Arrays.fill(ints,6);
        for (int i : ints
             ) {
            System.out.println(i);
        }
       List<StringAddress> list = new ArrayList<>(
        Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("word"));
        System.out.println(list);
    }
}
class StringAddress{
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;

    }

}
