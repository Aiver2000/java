package com.example.springboot3.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class UserService {
//    private final static Logger log =
//            LoggerFactory.getLogger(UserService.class);
    @RequestMapping("/sayhi2")
    public void sayHi2(){
        log.trace("我是 trace");
        log.debug("我是 debug");
        log.info("我是 info");
        log.warn("我是 warn");
        log.error("我是 error");

    }

}
