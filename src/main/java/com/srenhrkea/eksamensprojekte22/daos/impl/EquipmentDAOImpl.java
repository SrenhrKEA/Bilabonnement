package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.EquipmentDAO;
import com.srenhrkea.eksamensprojekte22.models.Equipment;
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
        int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");
        int idLease = rs.getInt("LeaseidLease");


        equipment = new Equipment();
        equipment.setIdEquipment(idEquipment);
        equipment.setIdEquipmentRef(idEquipmentRef);
        equipment.setIdLease(idLease);

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
        int idEquipmentRef = rs.getInt("EquipmentRefidEquipmentRef");
        int idLease = rs.getInt("LeaseidLease");

        Equipment equipment = new Equipment();
        equipment.setIdEquipment(idEquipment);
        equipment.setIdEquipmentRef(idEquipmentRef);
        equipment.setIdLease(idLease);


        equipmentList.add(equipment);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return equipmentList;
  }

  @Override
  public boolean save(Equipment equipment) {

    String sql = "INSERT INTO equipment(LeaseidLease,EquipmentRefidEquipmentRef)VALUES(?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, equipment.getIdLease());
      psts.setInt(2, equipment.getIdEquipmentRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Equipment is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(Equipment equipment) {

    String sql = "UPDATE equipment set LeaseidLease=?, EquipmentRefidEquipmentRef=? WHERE idEquipment=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, equipment.getIdLease());
      psts.setInt(2, equipment.getIdEquipmentRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Equipment Plan is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Integer id) {

    String sql = "DELETE FROM equipment WHERE idEquipment=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Equipment with ID " + id + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
