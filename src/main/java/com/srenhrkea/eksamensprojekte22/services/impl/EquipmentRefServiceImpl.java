package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.EquipmentRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.EquipmentRef;
import com.srenhrkea.eksamensprojekte22.services.EquipmentRefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentRefServiceImpl implements EquipmentRefService {

  private EquipmentRefDAOImpl equipmentRefDAO;

  public EquipmentRefServiceImpl(EquipmentRefDAOImpl equipmentRefDAO) {
    this.equipmentRefDAO = equipmentRefDAO;
  }

  @Override
  public EquipmentRef getEquipmentRefById(int id) {
    Optional<EquipmentRef> optional = equipmentRefDAO.get(id);
    EquipmentRef equipmentRef;
    if (optional.isPresent()) {
      equipmentRef = optional.get();
    } else {
      throw new RuntimeException(" EquipmentRef with ID: " + id + " does not exist");
    }
    return equipmentRef;
  }

  @Override
  public List<EquipmentRef> getAllEquipmentRefs() {
    return (List<EquipmentRef>) equipmentRefDAO.getAll();
  }

  @Override
  public void saveEquipmentRef(EquipmentRef equipmentRef) {
    this.equipmentRefDAO.save(equipmentRef);
  }

  @Override
  public void updateEquipmentRef(EquipmentRef equipmentRef) {
    int idEquipmentRef = equipmentRef.getIdEquipmentRef();
    Optional<EquipmentRef> optional = equipmentRefDAO.get(idEquipmentRef);
    if (optional.isPresent()) {
      equipmentRefDAO.update(equipmentRef);
    } else {
      throw new RuntimeException(" EquipmentRef with ID: " + idEquipmentRef + " does not exist");
    }
  }

  @Override
  public void deleteEquipmentRefById(int id) {
    Optional<EquipmentRef> optional = equipmentRefDAO.get(id);
    if (optional.isPresent()) {
      this.equipmentRefDAO.delete(id);
    } else {
      throw new RuntimeException(" EquipmentRef with ID: " + id + " does not exist");
    }
  }
}
