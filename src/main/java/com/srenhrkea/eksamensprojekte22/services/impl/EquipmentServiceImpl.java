package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.EquipmentDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Equipment;
import com.srenhrkea.eksamensprojekte22.services.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

  private EquipmentDAOImpl equipmentDAO;

  public EquipmentServiceImpl(EquipmentDAOImpl equipmentDAO) {
    this.equipmentDAO = equipmentDAO;
  }

  @Override
  public Equipment getEquipmentById(int id) {
    Optional<Equipment> optional = equipmentDAO.get(id);
    Equipment equipment;
    if (optional.isPresent()) {
      equipment = optional.get();
    } else {
      throw new RuntimeException(" Equipment with ID: " + id + " does not exist");
    }
    return equipment;
  }

  @Override
  public List<Equipment> getAllEquipment() {
    return (List<Equipment>) equipmentDAO.getAll();
  }

  @Override
  public List<Equipment> getAllEquipmentByIdLease(int id) {
    return (List<Equipment>) equipmentDAO.getAllByIdLease(id);
  }

  @Override
  public List<Equipment> getAllEquipmentByIdEquipmentRef(int id) {
    return (List<Equipment>) equipmentDAO.getAllByIdEquipmentRef(id);
  }

  @Override
  public void saveEquipment(Equipment equipment) {
    this.equipmentDAO.save(equipment);
  }

  @Override
  public void updateEquipment(Equipment equipment) {
    int idEquipment = equipment.getIdEquipment();
    Optional<Equipment> optional = equipmentDAO.get(idEquipment);
    if (optional.isPresent()) {
      equipmentDAO.update(equipment);
    } else {
      throw new RuntimeException(" Equipment with ID: " + idEquipment + " does not exist");
    }
  }

  @Override
  public void deleteEquipmentById(int id) {
    Optional<Equipment> optional = equipmentDAO.get(id);
    if (optional.isPresent()) {
      this.equipmentDAO.delete(id);
    } else {
      throw new RuntimeException(" Equipment with ID: " + id + " does not exist");
    }
  }
}
