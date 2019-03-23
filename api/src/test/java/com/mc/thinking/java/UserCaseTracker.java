package com.mc.thinking.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserCaseTracker {
    public static void trackUserCases(List<Integer> userCases, Class<?> cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            UserCase userCase = m.getAnnotation(UserCase.class);
            if(userCase != null){
                System.out.println(userCase.id() + " " + userCase.description() );
            }
            userCases.remove(new Integer(userCase.id()));
        }
        for ( int i : userCases){
            System.out.println("Warning : Missing user case - "+ i);
        }
    }
    public static void main(String[] args){
        List<Integer> userCases = new ArrayList<>();
        Collections.addAll(userCases,47,48,49,50);
        trackUserCases(userCases,PasswordUtils.class);


    }
}
