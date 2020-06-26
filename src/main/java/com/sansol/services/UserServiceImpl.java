package com.sansol.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.sansol.dao.UserDao;
import com.sansol.model.Login;
import com.sansol.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
