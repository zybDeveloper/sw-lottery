package com.wozyb.lottery.controller;

import com.alibaba.fastjson.JSON;
import com.wozyb.lottery.entity.User;
import com.wozyb.lottery.util.MyRowMapper;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by zyb on 18-12-17.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*用户登录授权*/
    @RequestMapping("userLoginWeixin")
    public void userLoginWeixin(){

    }

    /*用户签到*/
    @RequestMapping("userSign")
    public void userSign(){

    }

    /*导入用户数据*/
    @RequestMapping("importUserData")
    public void importUserData(){

    }


    /*增加用户*/
    @RequestMapping(value="adduser",method=RequestMethod.POST)
    public @ResponseBody String addUser(User user){
        String sql="INSERT into user(name,phone,number,image) VALUES (?,?,?,?)";
        Object []objects=new Object[]{user.getName(),user.getPhone(),user.getNumber(),user.getImage()};
        int result=0;
        for(int i=0;i<3000;i++){
            result=jdbcTemplate.update(sql,objects);
        }
        if(result>0){
            return "success";
        }
        return "fail";
    }


    //返回幸运用户列表对象
    @RequestMapping(value = "queryUser",method = RequestMethod.GET)
    public @ResponseBody String queryUser(int number){
        Random random=new Random();
        //查询语句
        String sql = "select * from user where isValid='0'";
        //本次中奖用户列表
        List<User> users=new ArrayList<User>();
        //所有已经签到用户列表的对象
        List<User> list=jdbcTemplate.query(sql,new MyRowMapper());
        for(int i=0;i<number;i++){
            int index=random.nextInt(list.size());
            //增加中奖标识
            updateUser(list.get(index).getId());
            //用户添加入中奖用户列表
            users.add(list.get(index));
        }
        return JSON.toJSONString(users);
    }

    //为用户添加已经中奖标识
    public void updateUser(int userId){
        Random random=new Random();
        String sql="update user set isValid=? where id = ?";
        //参数集
        Object o[]={"1",userId};
        int result=jdbcTemplate.update(sql,o);
    }

    //清空所有中奖标识
    public void clearLuckTag(){
        String sql="update user set isValid=0";
        int result=jdbcTemplate.update(sql);
    }
}
