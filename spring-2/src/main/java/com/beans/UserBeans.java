package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {

    @Bean(name = "userinfo")
    public User user1(){
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }
}
