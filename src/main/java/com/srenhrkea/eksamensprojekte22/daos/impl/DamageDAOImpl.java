package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.DamageDAO;
import com.srenhrkea.eksamensprojekte22.entities.Damage;
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
public class DamageDAOImpl implements DamageDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Damage> get(Integer id) throws SQLException {
    Damage damage = null;
    String sql = "SELECT *FROM damage WHERE idDamage=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idDamage = rs.getInt("idDamage");
      String title = rs.getString("title");
      String description = rs.getString("´description´");
      double price = rs.getDouble("price");
      int idDamageReport = rs.getInt("DamageReportidDamageReport");

      damage = new Damage();
      damage.setIdDamage(idDamage);
      damage.setTitle(title);
      damage.setDescription(description);
      damage.setPrice(price);
      damage.setIdDamageReport(idDamageReport);

    }

    assert damage != null;
    return Optional.of(damage);
  }

  @Override
  public Collection<Damage> getAll() throws SQLException {

    List<Damage> damages = new ArrayList<>();
    String sql = "SELECT *FROM damage";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idDamage = rs.getInt("idDamage");
      String title = rs.getString("title");
      String description = rs.getString("´description´");
      double price = rs.getDouble("price");
      int idDamageReport = rs.getInt("DamageReportidDamageReport");

      Damage damage = new Damage();
      damage.setIdDamage(idDamage);
      damage.setTitle(title);
      damage.setDescription(description);
      damage.setPrice(price);
      damage.setIdDamageReport(idDamageReport);

      damages.add(damage);
    }

    return damages;
  }

  @Override
  public Collection<Damage> getAllByIdDamageReport(Integer id) throws SQLException {

    List<Damage> damages = new ArrayList<>();
    String sql = "SELECT *FROM damage WHERE DamageReportidDamageReport=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idDamage = rs.getInt("idDamage");
      String title = rs.getString("title");
      String description = rs.getString("´description´");
      double price = rs.getDouble("price");
      int idDamageReport = rs.getInt("DamageReportidDamageReport");

      Damage damage = new Damage();
      damage.setIdDamage(idDamage);
      damage.setTitle(title);
      damage.setDescription(description);
      damage.setPrice(price);
      damage.setIdDamageReport(idDamageReport);

      damages.add(damage);
    }

    return damages;
  }

  @Override
  public boolean save(Damage damage) throws SQLException {

    String sql = "INSERT INTO damage (title,´description´,price, DamageReportidDamageReport)VALUES(?,?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, damage.getTitle());
    psts.setString(2, damage.getDescription());
    psts.setDouble(3, damage.getPrice());
    psts.setInt(4, damage.getIdDamageReport());


    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Damage is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(Damage damage) throws SQLException {

    String sql = "UPDATE damage set title=?, ´description´=?, price=?, DamageReportidDamageReport=? WHERE idDamage=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, damage.getTitle());
    psts.setString(2, damage.getDescription());
    psts.setDouble(3, damage.getPrice());
    psts.setInt(4, damage.getIdDamageReport());
    psts.setInt(5, damage.getIdDamage());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Damage is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM damage WHERE idDamage=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Damage with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
