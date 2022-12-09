package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.EquipmentRef;

import java.sql.SQLException;
import java.util.List;

public interface EquipmentRefService {

  EquipmentRef getEquipmentRefById(int id) throws Exception;

  List<EquipmentRef> getAllEquipmentRefs() throws SQLException;

  boolean saveEquipmentRef(EquipmentRef equipmentRef) throws SQLException;

  boolean updateEquipmentRef(EquipmentRef equipmentRef) throws SQLException;

  boolean deleteEquipmentRefById(int id) throws SQLException;

}
