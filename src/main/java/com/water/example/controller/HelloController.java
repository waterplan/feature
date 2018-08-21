package com.water.example.controller;

import com.water.example.donain.User;
import com.water.example.mapper.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        User user = userRepository.findUserById((long) 1);
        LOG.info("hello :{user}",user);
        throw new RuntimeException("hello");
    }


    @RequestMapping(value = "upload",method = RequestMethod.GET)
    public String upload(){

        return "upload";
    }


}
