package com.chen.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Demo {

    @dd(value = "hri", age = 10)
    public void d() {
        System.out.println("111");
        System.out.println("t1 111");
    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@interface dd{
    String[] value();

    int age();
}

