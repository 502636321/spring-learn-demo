package com.example.spring.learn.demo.entity;

import org.springframework.stereotype.Component;

/**
 * 猴子
 */
@Component
public class Monkey implements Animal {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
