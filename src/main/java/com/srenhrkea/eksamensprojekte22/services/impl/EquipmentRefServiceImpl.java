package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.EquipmentRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.EquipmentRef;
import com.srenhrkea.eksamensprojekte22.services.EquipmentRefService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentRefServiceImpl implements EquipmentRefService {

  private EquipmentRefDAOImpl equipmentRefDAO;

  public EquipmentRefServiceImpl(EquipmentRefDAOImpl equipmentRefDAO) {
    this.equipmentRefDAO = equipmentRefDAO;
  }

  @Override
  public EquipmentRef getEquipmentRefById(int id) throws Exception {
    Optional<EquipmentRef> equipmentRef = equipmentRefDAO.get(id);
    return equipmentRef.orElseThrow(
        () -> new Exception("An equipmentRef with ID: " + id + ", does not exist."));
  }

  @Override
  public List<EquipmentRef> getAllEquipmentRefs() throws SQLException {
    return (List<EquipmentRef>) equipmentRefDAO.getAll();
  }

  @Override
  public boolean saveEquipmentRef(EquipmentRef equipmentRef) throws SQLException {
    return equipmentRefDAO.save(equipmentRef);
  }

  @Override
  public boolean updateEquipmentRef(EquipmentRef equipmentRef) throws SQLException {
    return equipmentRefDAO.update(equipmentRef);
  }

  @Override
  public boolean deleteEquipmentRefById(int id) throws SQLException {
    return equipmentRefDAO.delete(id);
  }
}
