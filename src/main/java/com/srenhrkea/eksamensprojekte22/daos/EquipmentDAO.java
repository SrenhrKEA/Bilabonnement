package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.entities.Equipment;

import java.sql.SQLException;
import java.util.Collection;

public interface EquipmentDAO extends GenericDAO<Equipment, Integer> {
  Collection<Equipment> getAllByIdLease(Integer id) throws SQLException;
  Collection<Equipment> getAllByIdEquipmentRef(Integer id) throws SQLException;

}
