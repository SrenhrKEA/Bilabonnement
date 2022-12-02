package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.EquipmentDAO;
import com.srenhrkea.eksamensprojekte22.models.Equipment;

import java.util.Collection;
import java.util.Optional;

public class EquipmentDAOImpl implements EquipmentDAO {

  @Override
  public Optional<Equipment> get(Integer integer) {
    return Optional.empty();
  }

  @Override
  public Collection<Equipment> getAll() {
    return null;
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
    return false;
  }
}
