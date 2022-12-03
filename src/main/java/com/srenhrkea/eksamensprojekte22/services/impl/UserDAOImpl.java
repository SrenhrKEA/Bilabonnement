package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.enums.UserType;
import com.srenhrkea.eksamensprojekte22.models.User;
import com.srenhrkea.eksamensprojekte22.services.UserDAO;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<User> get(String id) {
    User user = null;
    String sql = "SELECT *FROM user WHERE username=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

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

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert user != null;
    return Optional.of(user);
  }

  @Override
  public Collection<User> getAll() {

    List<User> users = new ArrayList<>();
    String sql = "SELECT *FROM user";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

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

    } catch (Exception e) {
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public boolean save(User user) {

    String sql = "INSERT INTO user(username,´password´,userType)VALUES(?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, user.getUsername());
      psts.setString(2, user.getPassword());
      psts.setString(3, String.valueOf(user.getUserType()));

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("User is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(User user) {

    String sql = "UPDATE user set ´password´=?, userType=? WHERE username=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, user.getPassword());
      psts.setString(2, String.valueOf(user.getUserType()));
      psts.setString(3, user.getUsername());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("User is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(User user) {

    String sql = "DELETE FROM user WHERE username=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, user.getUsername());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("User with username " + user.getUsername() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
