package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.Equipment;

import java.sql.SQLException;
import java.util.List;

public interface EquipmentService {

  Equipment getEquipmentById(int id) throws Exception;

  List<Equipment> getAllEquipment() throws SQLException;

  List<Equipment> getAllEquipmentByIdLease(int id) throws SQLException;

  List<Equipment> getAllEquipmentByIdEquipmentRef(int id) throws SQLException;

  boolean saveEquipment(Equipment equipment) throws SQLException;

  boolean updateEquipment(Equipment equipment) throws SQLException;

  boolean deleteEquipmentById(int id) throws SQLException;

}
