package com.csp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/list")
    public String form(){
        return "list";
    }

    @RequestMapping("/login-error")
    public String loginError(String str,int age){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.getDayOfMonth();
        return "error";
    }

}
