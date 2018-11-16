package com.my.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by lilianga on 2018/11/12.
 */

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}
