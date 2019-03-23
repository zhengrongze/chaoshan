package com.mc.thinking.java.jihe13;

import java.util.*;

/**
 * Collection实现了Iterable接口,所以任何类实现这个接口就可以使用foreach
 */
public class IterableClass implements Iterable<String> {
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private String words [] = ("a b c d e f g").split(" ");
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String [] args){
        for (String s : new IterableClass()){
            System.out.print(" " + s);
        }
    }


}
