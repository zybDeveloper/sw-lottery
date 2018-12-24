package com.wozyb.lottery.dao;

import com.wozyb.lottery.entity.Admin;
import com.wozyb.lottery.util.AdminRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ManagerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*查询密码*/
    private final static String QUERY_PASSWORD="select id,username,password from admin where username=? and password=?";

    /*查询用户列表*/
    private final static String QUERY_USER="select id,username,password from admin where username=?";


    /*登录查询方法*/
    public boolean checkLogin(String username,String password){
        Object [] obj=new Object[]{username,password};
        List<Map<String,Object>> listmap=jdbcTemplate.queryForList(QUERY_PASSWORD,obj);
        if(listmap!=null&&listmap.size()>0){
            return true;
        }else{
            return false;
        }
    }


    /*查询用户列表方法*/
    public List<Admin> queryListAdmin(String username){
        Object [] obj=new Object[]{username};
        List<Map<String,Object>> listmap=jdbcTemplate.queryForList(QUERY_USER,obj);
        List<Admin> alist=new ArrayList<>();
        if(listmap.size()>0){
            //存在问题
            for(int i =0;i<listmap.size();i++){
                Map adminMap=listmap.get(i);
                Admin admin=new Admin();
                admin.setId(Integer.parseInt(adminMap.get("id").toString()));
                admin.setUsername(adminMap.get("username").toString());
                admin.setPassword(adminMap.get("password").toString());
                alist.add(admin);
                System.out.println(adminMap.get("id"));
                System.out.println(adminMap.get("username"));
                System.out.println(adminMap.get("password"));
            }
            return alist;
        }
        return null;
    }

}