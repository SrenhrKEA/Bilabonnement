package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.UserDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.User;
import com.srenhrkea.eksamensprojekte22.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private UserDAOImpl userDAO;

  public UserServiceImpl(UserDAOImpl userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public User getUserById(String id) {
    Optional<User> optional = userDAO.get(id);
    User user;
    if (optional.isPresent()) {
      user = optional.get();
    } else {
      throw new RuntimeException(" User with username: " + id + " does not exist");
    }
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    return (List<User>) userDAO.getAll();
  }

  @Override
  public void saveUser(User user) {
    this.userDAO.save(user);
  }

  @Override
  public void updateUser(User user, String idNew) {
    String idUser = user.getUsername();
    Optional<User> optional = userDAO.get(idUser);
    if (optional.isPresent()) {
      userDAO.update(user, idNew);
    } else {
      throw new RuntimeException(" User with username: " + idNew + " does not exist");
    }
  }

  @Override
  public void deleteUserById(String id) {
    Optional<User> optional = userDAO.get(id);
    if (optional.isPresent()) {
      this.userDAO.delete(id);
    } else {
      throw new RuntimeException(" User with username: " + id + " does not exist");
    }
  }
}
