package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.EquipmentDAO;
import com.srenhrkea.eksamensprojekte22.models.Equipment;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EquipmentDAOImpl implements EquipmentDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Equipment> get(Integer id) {
    Equipment equipment = null;
    String sql = "SELECT *FROM equipment WHERE idEquipment=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idEquipment = rs.getInt("idEquipment");
        int idLease = rs.getInt("LeaseidLease");
        int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");


        equipment = new Equipment();
        equipment.setIdEquipment(idEquipment);
        equipment.setIdEquipment(idLease);
        equipment.setIdEquipment(idEquipmentRef);


      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert equipment != null;
    return Optional.of(equipment);
  }

  @Override
  public Collection<Equipment> getAll() {

    List<Equipment> equipmentList = new ArrayList<>();
    String sql = "SELECT *FROM equipment";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idEquipment = rs.getInt("idEquipment");
        int idLease = rs.getInt("LeaseidLease");
        int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");


        Equipment equipment = new Equipment();
        equipment.setIdEquipment(idEquipment);
        equipment.setIdEquipment(idLease);
        equipment.setIdEquipment(idEquipmentRef);

        equipmentList.add(equipment);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return equipmentList;
  }

  @Override
  public boolean save(Equipment equipment) {
    return false;
  }

  @Override
  public boolean update(Equipment equipment) {
    return false;
  }

  @Override
  public boolean delete(Equipment equipment) {

    String sql = "DELETE FROM equipment WHERE idEquipment=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, equipment.getIdEquipment());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Equipment with ID " + equipment.getIdEquipment() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
