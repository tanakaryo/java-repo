package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    private int counter;

    @Value("${greeting}")
    private String say;

    public String saySomething(String body) {
        return String.format("%s I am invoked %d times", say, ++counter);
    }
}
