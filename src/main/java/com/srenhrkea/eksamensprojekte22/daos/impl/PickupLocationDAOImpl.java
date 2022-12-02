package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.PickupLocationDAO;
import com.srenhrkea.eksamensprojekte22.models.PickupLocation;

import java.util.Collection;
import java.util.Optional;

public class PickupLocationDAOImpl implements PickupLocationDAO {

  @Override
  public Optional<PickupLocation> get(Integer integer) {
    return Optional.empty();
  }

  @Override
  public Collection<PickupLocation> getAll() {
    return null;
  }

  @Override
  public boolean save(PickupLocation pickupLocation) {
    return false;
  }

  @Override
  public boolean update(PickupLocation pickupLocation) {
    return false;
  }

  @Override
  public boolean delete(PickupLocation pickupLocation) {
    return false;
  }
}
