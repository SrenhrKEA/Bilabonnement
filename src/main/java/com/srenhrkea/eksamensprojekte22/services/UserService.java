package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

  User getUserById(String username) throws Exception;

  List<User> getAllUsers();

  void saveUser(User user);

  void updateUser(User user, String username) throws Exception;

  void deleteUserById(String username) throws Exception;

  User AuthenticateUser(String username, String password) throws Exception;

}
