package com.mc.thinking.java;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    String name() default "rongze";
    int [] value() default {111,222};
}
