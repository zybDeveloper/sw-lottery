package com.wozyb.lottery.util;

import com.wozyb.lottery.entity.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin>{

    @Override
    public Admin mapRow(ResultSet rs,int num) throws SQLException{
        Admin admin=new Admin();
        admin.setId(rs.getInt("id"));
        admin.setUsername(rs.getString("username"));
        admin.setPassword(rs.getString("password"));
        return admin;
    }
}
