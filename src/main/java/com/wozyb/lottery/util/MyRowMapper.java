package com.wozyb.lottery.util;

import com.wozyb.lottery.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int num) throws SQLException {
        User user=new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setImage(rs.getString("image"));
        user.setNumber(rs.getString("number"));
        user.setPhone(rs.getString("phone"));
        user.setIsVail(rs.getString("isValid"));
        return user;
    }
}
