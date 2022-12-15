package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.UserDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.User;
import com.srenhrkea.eksamensprojekte22.services.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private UserDAOImpl userDAO;

  public UserServiceImpl(UserDAOImpl userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public User getUserById(String id) throws Exception {
    Optional<User> user = userDAO.get(id);
    return user.orElseThrow(
        () -> new Exception("An user with ID: " + id + ", does not exist."));
  }

  @Override
  public List<User> getAllUsers() throws SQLException {
    return (List<User>) userDAO.getAll();
  }

  @Override
  public boolean saveUser(User user) throws SQLException {
    return userDAO.save(user);
  }

  @Override
  public boolean updateUser(User user, String idNew) throws SQLException {
    return userDAO.update(user, idNew);

  }

  @Override
  public boolean deleteUserById(String id) throws SQLException {
    return userDAO.delete(id);
  }

  @Override
  public User AuthenticateUser(String username, String password) throws Exception {
    Optional<User> user = userDAO.get(username, password);
    return user.orElseThrow(
        () -> new Exception("An user with ID: " + username + " and password:" + password + " does not exist."));
  }
}
