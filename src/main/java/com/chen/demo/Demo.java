package com.chen.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Demo {

    @dd({})
    public void d() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@interface dd{
    String[] value();
}
