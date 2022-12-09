package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.EquipmentRefDAO;
import com.srenhrkea.eksamensprojekte22.models.EquipmentRef;
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
public class EquipmentRefDAOImpl implements EquipmentRefDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<EquipmentRef> get(Integer id) throws SQLException {
    EquipmentRef equipmentRef = null;
    String sql = "SELECT *FROM equipmentref WHERE idEquipmentRef=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idEquipmentRef = rs.getInt("idEquipmentRef");
      String title = rs.getString("title");
      String description = rs.getString("´description´");
      double price = rs.getDouble("price");

      equipmentRef = new EquipmentRef();
      equipmentRef.setIdEquipmentRef(idEquipmentRef);
      equipmentRef.setTitle(title);
      equipmentRef.setDescription(description);
      equipmentRef.setPrice(price);

    }

    assert equipmentRef != null;
    return Optional.of(equipmentRef);
  }

  @Override
  public Collection<EquipmentRef> getAll() throws SQLException {

    List<EquipmentRef> equipmentRefs = new ArrayList<>();
    String sql = "SELECT *FROM equipmentref";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idEquipmentRef = rs.getInt("idEquipmentRef");
      String title = rs.getString("title");
      String description = rs.getString("´description´");
      double price = rs.getDouble("price");

      EquipmentRef equipmentRef = new EquipmentRef();
      equipmentRef.setIdEquipmentRef(idEquipmentRef);
      equipmentRef.setTitle(title);
      equipmentRef.setDescription(description);
      equipmentRef.setPrice(price);

      equipmentRefs.add(equipmentRef);
    }

    return equipmentRefs;
  }

  @Override
  public boolean save(EquipmentRef equipmentRef) throws SQLException {

    String sql = "INSERT INTO equipmentref (title,´description´,price)VALUES(?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, equipmentRef.getTitle());
    psts.setString(2, equipmentRef.getDescription());
    psts.setDouble(3, equipmentRef.getPrice());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Equipment Reference is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(EquipmentRef equipmentRef) throws SQLException {

    String sql = "UPDATE equipmentref set title=?, ´description´=?, price=? WHERE idEquipmentRef=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, equipmentRef.getTitle());
    psts.setString(2, equipmentRef.getDescription());
    psts.setDouble(3, equipmentRef.getPrice());
    psts.setInt(4, equipmentRef.getIdEquipmentRef());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Equipment Reference is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM equipmentref WHERE idEquipmentRef=?;";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Equipment Reference with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
