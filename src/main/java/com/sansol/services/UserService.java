package com.sansol.services;

import com.sansol.model.Login;
import com.sansol.model.User;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
}
