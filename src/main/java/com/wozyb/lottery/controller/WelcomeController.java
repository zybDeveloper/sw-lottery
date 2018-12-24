package com.wozyb.lottery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.Date;

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

    /*跳转后台管理页面*/
    @GetMapping("/backManager")
    public String backManager(HttpSession session){
        logger.info("success!");
        if(session==null){
            return "error";
        }
        String s=session.getAttribute("login").toString();
        if("yes".equals(s)){
            return "Manager";
        }
        return "error";
    }


    /*跳转后台管理登录页面*/
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
