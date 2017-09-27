package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/25.
 */

@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public String hello(){
        System.out.println("HelloWorld");
        return "Hello World";
    }

   /* @RequestMapping("/toindex.do")
    public ModelAndView toindex(){
        System.out.println("ToLogin");
        return new ModelAndView("index");
    }*/



    @RequestMapping("/tologin1")
    public String tologin1(){
        System.out.println("ToLogin1");
        return "index";
    }
}
