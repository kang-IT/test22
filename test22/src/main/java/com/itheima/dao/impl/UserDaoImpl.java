package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.DataSourceUtils;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());

    @Override
    public User find(User user) {
        System.out.println("dao层"+user);
        User u = null;
        try {
            String sql = "SELECT * FROM USER WHERE username=? AND password=?";
             u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());

        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }
}
