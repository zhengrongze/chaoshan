package com.mc.thinking.java;

import java.lang.reflect.Method;

public class test {

    public static void main(String [] args){
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> clazz = TargetTest.class;
        stringBuilder.append("Method注解：").append("\n");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            System.out.println(useCase.name());
            int [] ints = useCase.value();
            for (Integer i:ints) {
                System.out.println(i);
            }
        }
    }

}

