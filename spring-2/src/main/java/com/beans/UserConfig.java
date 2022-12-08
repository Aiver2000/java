package com.beans;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    public void sayHi(){
        System.out.println("你好，config！");
    }
}
