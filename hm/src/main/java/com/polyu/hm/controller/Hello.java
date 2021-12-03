package com.polyu.hm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @RequestMapping("/hello")
    public String hello(Model model) {
        return "index1";
    }

    @RequestMapping("/hello1")
    public String hello1(Model model) {
        return "index1";
    }

    @RequestMapping("/school")
    public synchronized String school(Model model) {
        return "school";
    }
}
