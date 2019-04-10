package demoSpringboot.service;
 
import java.util.List;

import demoSpringboot.entity.User;

public abstract interface UserService
{
  public abstract List<User> GetUserInfo();
}
