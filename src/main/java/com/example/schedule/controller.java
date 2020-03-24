package com.example.schedule;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

@Controller
public class controller {

    @RequestMapping("/index")
    public String toindex(){
        System.out.println("ffff");
        return "local/index";
    }

    @RequestMapping("/gg")
    public String error(){
        return "local/inggdex";
    }

}
