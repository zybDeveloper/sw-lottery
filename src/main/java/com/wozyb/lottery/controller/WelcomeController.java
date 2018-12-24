package com.wozyb.lottery.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

@Controller
public class WelcomeController {

    Logger logger= LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public ModelAndView hello(HttpSession session){
        Object username=session.getAttribute("username");
        if(username == null){
            username="张三";
            session.setAttribute("username",username);
        }
        ModelMap modelMap=new ModelMap("message","个人信息简介")
                .addAttribute("username",username)
                .addAttribute("title","userinfo")
                .addAttribute("date",new Date());
        return new ModelAndView("welcome",modelMap);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
