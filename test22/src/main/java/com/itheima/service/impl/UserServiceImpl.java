package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
  private UserDao userDao = new UserDaoImpl();
    @Override
    public User find(User user) {

        User user1 = userDao.find(user);
        return user1;
    }
}
