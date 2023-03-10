package com.srenhrkea.eksamensprojekte22.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
  private static Connection conn;

  public static Connection getConnection() {
    if (conn != null) {
      return conn;
    }

    String hostname = System.getenv("DB.URL");
    String username = System.getenv("DB.USERNAME");
    String password = System.getenv("DB.PASSWORD");

    try {
      conn = DriverManager.getConnection(hostname, username, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }
}
