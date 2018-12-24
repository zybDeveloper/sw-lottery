package com.wozyb.lottery.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class PersonController {

    @GetMapping("/queryPersons")
    public int queryPersons(){
        Random random=new Random();
        return random.nextInt(1000);
    }
}
