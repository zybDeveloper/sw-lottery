package com.wozyb.lottery.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* 奖项设置
* */
@RestController
@RequestMapping
public class PrizeController {

    //设置奖项
    @RequestMapping(value="setprize",method = RequestMethod.POST)
    public String setPrize(){
        return "";
    }
}
