package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

  User getUserById(String username) throws Exception;

  List<User> getAllUsers() throws SQLException;

  boolean saveUser(User user) throws SQLException;

  boolean updateUser(User user, String username) throws SQLException;

  boolean deleteUserById(String username) throws SQLException;

  User AuthenticateUser(String username, String password) throws Exception;

}
