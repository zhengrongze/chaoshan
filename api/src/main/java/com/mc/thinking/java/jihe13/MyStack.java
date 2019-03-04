package com.mc.thinking.java.jihe13;

import java.util.LinkedList;

public class MyStack<T>  {

    private LinkedList<T> list = new LinkedList<>();
    public void push(T o){
        list.addFirst(o);
    }
    public T pop(){
        return list.removeFirst();
    }
}
