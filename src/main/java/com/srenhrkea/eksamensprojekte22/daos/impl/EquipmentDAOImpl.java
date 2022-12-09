package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.EquipmentDAO;
import com.srenhrkea.eksamensprojekte22.models.Equipment;
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
public class EquipmentDAOImpl implements EquipmentDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Equipment> get(Integer id) throws SQLException {
    Equipment equipment = null;
    String sql = "SELECT *FROM equipment WHERE idEquipment=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idEquipment = rs.getInt("idEquipment");
      int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");
      int idLease = rs.getInt("LeaseidLease");


      equipment = new Equipment();
      equipment.setIdEquipment(idEquipment);
      equipment.setIdEquipmentRef(idEquipmentRef);
      equipment.setIdLease(idLease);

    }


    assert equipment != null;
    return Optional.of(equipment);
  }

  @Override
  public Collection<Equipment> getAll() throws SQLException {

    List<Equipment> equipmentList = new ArrayList<>();
    String sql = "SELECT *FROM equipment";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idEquipment = rs.getInt("idEquipment");
      int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");
      int idLease = rs.getInt("LeaseidLease");

      Equipment equipment = new Equipment();
      equipment.setIdEquipment(idEquipment);
      equipment.setIdEquipmentRef(idEquipmentRef);
      equipment.setIdLease(idLease);


      equipmentList.add(equipment);
    }

    return equipmentList;
  }

  @Override
  public Collection<Equipment> getAllByIdLease(Integer id) throws SQLException {

    List<Equipment> equipmentList = new ArrayList<>();
    String sql = "SELECT *FROM equipment WHERE LeaseidLease=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idEquipment = rs.getInt("idEquipment");
      int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");
      int idLease = rs.getInt("LeaseidLease");

      Equipment equipment = new Equipment();
      equipment.setIdEquipment(idEquipment);
      equipment.setIdEquipmentRef(idEquipmentRef);
      equipment.setIdLease(idLease);


      equipmentList.add(equipment);
    }

    return equipmentList;
  }

  @Override
  public Collection<Equipment> getAllByIdEquipmentRef(Integer id) throws SQLException {

    String sql = "SELECT *FROM equipment WHERE EquipmentRefidEquipmentRef=?";
    List<Equipment> equipmentList = new ArrayList<>();
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idEquipment = rs.getInt("idEquipment");
      int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");
      int idLease = rs.getInt("LeaseidLease");

      Equipment equipment = new Equipment();
      equipment.setIdEquipment(idEquipment);
      equipment.setIdEquipmentRef(idEquipmentRef);
      equipment.setIdLease(idLease);


      equipmentList.add(equipment);
    }

    return equipmentList;
  }

  @Override
  public boolean save(Equipment equipment) throws SQLException {

    String sql = "INSERT INTO equipment(LeaseidLease,EquipmentRefidEquipmentRef)VALUES(?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, equipment.getIdLease());
    psts.setInt(2, equipment.getIdEquipmentRef());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Equipment is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(Equipment equipment) throws SQLException {

    String sql = "UPDATE equipment set LeaseidLease=?, EquipmentRefidEquipmentRef=? WHERE idEquipment=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, equipment.getIdLease());
    psts.setInt(2, equipment.getIdEquipmentRef());
    psts.setInt(3, equipment.getIdEquipment());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Equipment Plan is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM equipment WHERE idEquipment=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Equipment with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
