package com.wozyb.lottery.service;

import com.wozyb.lottery.dao.ManagerDao;
import com.wozyb.lottery.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServcie {

    @Autowired
    ManagerDao managerDao;

    public boolean checklogin(String username,String password){
        return managerDao.checkLogin(username,password);
    }

    public List<Admin> queryUserList(String username){
        return managerDao.queryListAdmin(username);
    }

}
