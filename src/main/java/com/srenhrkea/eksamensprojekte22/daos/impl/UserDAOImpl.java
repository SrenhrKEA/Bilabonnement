package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.UserDAO;
import com.srenhrkea.eksamensprojekte22.enums.UserType;
import com.srenhrkea.eksamensprojekte22.entities.User;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<User> get(String id) throws SQLException {
    User user = null;
    String sql = "SELECT *FROM user WHERE username=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      String username = rs.getString("username");
      String password = rs.getString("´password´");
      UserType userType = UserType.valueOf(rs.getString("userType"));

      user = new User();
      user.setUsername(username);
      user.setPassword(password);
      user.setUserType(userType);
    }

    assert user != null;
    return Optional.of(user);
  }

  @Override
  public Optional<User> get(String id, String pw) throws SQLException {
    User user = null;
    String sql = "SELECT *FROM user WHERE username=? AND ´password´=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, id);
    psts.setString(2, pw);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      String username = rs.getString("username");
      String password = rs.getString("´password´");
      UserType userType = UserType.valueOf(rs.getString("userType"));

      user = new User();
      user.setUsername(username);
      user.setPassword(password);
      user.setUserType(userType);
    }

    assert user != null;
    return Optional.of(user);
  }

  @Override
  public Collection<User> getAll() throws SQLException {

    List<User> users = new ArrayList<>();
    String sql = "SELECT *FROM user";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      String username = rs.getString("username");
      String password = rs.getString("´password´");
      UserType userType = UserType.valueOf(rs.getString("userType"));

      User user = new User();
      user.setUsername(username);
      user.setPassword(password);
      user.setUserType(userType);

      users.add(user);
    }

    return users;
  }

  @Override
  public boolean save(User user) throws SQLException {

    String sql = "INSERT INTO user(username,´password´,userType)VALUES(?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, user.getUsername());
    psts.setString(2, user.getPassword());
    psts.setString(3, String.valueOf(user.getUserType()));

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("User is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(User user) {
    return false;
  }

  @Override
  public boolean update(User user, String idNew) throws SQLException {

    String sql = "UPDATE user set username=?, ´password´=?, userType=? WHERE username=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, idNew);
    psts.setString(2, user.getPassword());
    psts.setString(3, String.valueOf(user.getUserType()));
    psts.setString(4, user.getUsername());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("User is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(String id) throws SQLException {

    String sql = "DELETE FROM user WHERE username=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("User with username " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
