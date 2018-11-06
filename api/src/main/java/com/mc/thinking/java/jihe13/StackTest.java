package com.mc.thinking.java.jihe13;

import java.util.Stack;

/**
 * 栈
 */
public class StackTest {
    public static void main(String [] args){
        Stack stack = new Stack();
        if(stack.empty()){
            System.out.println("stack is not element");
        }
        for (String s : "my na me ss dds ".split(" ")) {
            stack.push(s);
        }
        //弹出
        Object o = stack.pop();
        System.out.println(o);
        if(!stack.empty()){
            System.out.println("stack have elements");
        }
    }
}
