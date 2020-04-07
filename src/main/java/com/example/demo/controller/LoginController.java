package com.example.demo.controller;

import com.example.demo.util.TokenUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @RequestMapping("Login")
    public String login(HttpServletResponse response){
        boolean isSuccess= true;
        if (isSuccess){
            String token=TokenUtil.sign("test","uuidtest");
            Cookie cookie=new Cookie("token",token);
            response.addCookie(cookie);
            return token;
        }
        return "";
    }
    @RequestMapping("test")
    public String interceptor(){
        return "拦截器测试";
    }
}
