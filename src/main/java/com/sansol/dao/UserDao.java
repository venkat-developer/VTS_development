package com.sansol.dao;

import com.sansol.model.Login;
import com.sansol.model.User;

public interface UserDao {

  int register(User user);

  User validateUser(Login login);
}
