package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.EquipmentDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Equipment;
import com.srenhrkea.eksamensprojekte22.services.EquipmentService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

  private EquipmentDAOImpl equipmentDAO;

  public EquipmentServiceImpl(EquipmentDAOImpl equipmentDAO) {
    this.equipmentDAO = equipmentDAO;
  }

  @Override
  public Equipment getEquipmentById(int id) throws Exception {
    Optional<Equipment> equipment = equipmentDAO.get(id);
    return equipment.orElseThrow(
        () -> new Exception("An equipment with ID: " + id + ", does not exist."));
  }

  @Override
  public List<Equipment> getAllEquipment() throws SQLException {
    return (List<Equipment>) equipmentDAO.getAll();
  }

  @Override
  public List<Equipment> getAllEquipmentByIdLease(int id) throws SQLException {
    return (List<Equipment>) equipmentDAO.getAllByIdLease(id);
  }

  @Override
  public List<Equipment> getAllEquipmentByIdEquipmentRef(int id) throws SQLException {
    return (List<Equipment>) equipmentDAO.getAllByIdEquipmentRef(id);
  }

  @Override
  public boolean saveEquipment(Equipment equipment) throws SQLException {
    return equipmentDAO.save(equipment);
  }

  @Override
  public boolean updateEquipment(Equipment equipment) throws SQLException {
    return equipmentDAO.update(equipment);
  }

  @Override
  public boolean deleteEquipmentById(int id) throws SQLException {
    return equipmentDAO.delete(id);
  }
}
