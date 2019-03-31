package com.mc.java程序语言设计.zhang19;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Stack;

public class Test20_9 {
    public static void main(String [] args){
        String s = "3 + ( 4 + 5 ) * ( 3 + 5 ) + 4 * 5";
//        String s = "4 * 5 5 5";//结果会为10报错，可以先用正则检验格式，错误的话直接返回错误信息
        Integer result = evaluteExpression(s);
        System.out.println(result);
    }
    public static int evaluteExpression(String expression){
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        expression = insertBlanks(expression);

        String [] tokens = expression.split(" ");
        for (String token : tokens) {
            if(token.length() == 0){
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                        operatorStack.peek() == '-' ||
                        operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/' )){
                    processAnOperator(operandStack,operatorStack);
                }
                //如果是第一次直接压入操作栈中
                operatorStack.push(token.charAt(0));
            }else if(token.charAt(0) == '*' || token.charAt(0) == '/'){
                while (!operatorStack.isEmpty() &&
                (operatorStack.peek() == '*' || operandStack.peek() == '/')){
                    processAnOperator(operandStack,operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }else  if(token.trim().charAt(0) == '('){
                operatorStack.push('(');
            }else  if(token.trim().charAt(0) == ')'){
                while (operatorStack.peek() !='('){
                    processAnOperator(operandStack,operatorStack);
                }
                operatorStack.pop();
            }
            else {
                operandStack.push(new Integer(token));
            }
        }
        while (!operatorStack.isEmpty()){
            processAnOperator(operandStack,operatorStack);
        }
        return operandStack.pop();
    }
    public static void processAnOperator(Stack<Integer> operandStack,Stack<Character> operatorStack){
        //弹出并删除栈中元素
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if(op == '+')
            operandStack.push(op2 + op1);
        if(op == '-')
            operandStack.push(op2 - op1);
        if(op == '*')
            operandStack.push(op2 * op1);
        if(op == '/')
            operandStack.push(op2 / op1);
    }
    public static String insertBlanks(String s){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/' ){
                result += "" + s.charAt(i) + "";
            }else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
