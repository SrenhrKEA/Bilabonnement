package com.srenhrkea.eksamensprojekte22.entities;

import com.srenhrkea.eksamensprojekte22.enums.UserType;

public class User {
  private String username, password;
  private UserType userType;

  public User() {
  }

  public User(String username, String password, UserType userType) {
    this.username = username;
    this.password = password;
    this.userType = userType;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", userType=" + userType +
        '}';
  }
}
