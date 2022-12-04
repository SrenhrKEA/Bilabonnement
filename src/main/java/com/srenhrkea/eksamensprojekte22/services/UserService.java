package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.User;

import java.util.List;

public interface UserService {

  User getUserById(String id);

  List<User> getAllUsers();

  void saveUser(User user);

  void updateUser(User user, String id);

  void deleteUserById(String id);

}
