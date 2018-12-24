package com.wozyb.lottery.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wozyb.lottery.entity.Admin;
import com.wozyb.lottery.service.ManagerServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerServcie managerServcie;

    /*后台管理用户登录*/
    @RequestMapping(value = "backLogin",method = RequestMethod.POST)
    public @ResponseBody JSONObject backLogin(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HashMap<String,String> resp=new HashMap<>();
        JSONObject result=new JSONObject();
        //查询
        boolean b=managerServcie.checklogin(username,password);
        if(b){
            resp.put("code","0");
            resp.put("status","success");
            resp.put("msg","msg");
            resp.put("user","user success");
        }else{
            resp.put("code","1");
            resp.put("status","fail");
            resp.put("msg","msg");
            resp.put("user","user fail");
        }
        result.put("data",resp);
        return result;
    }


    /*后台管理用户登录*/
    @RequestMapping(value = "queryUserList",method = RequestMethod.POST)
    public @ResponseBody JSONObject queryUserList(HttpServletRequest request){
        String username=request.getParameter("username");
        HashMap<String,String> resp=new HashMap<String,String>();
        JSONObject result=new JSONObject();
        //查询
        List<Admin> list=managerServcie.queryUserList(username);
        if (list!=null&&list.size()>0){
            resp.put("code","0");
            resp.put("status","success");
            resp.put("msg","msg");
            resp.put("user", JSON.toJSONString(list));
        }else{
            resp.put("code","1");
            resp.put("status","fail");
            resp.put("msg","fail");
            resp.put("user","");
        }
        result.put("data",resp);
        return result;
    }
}
