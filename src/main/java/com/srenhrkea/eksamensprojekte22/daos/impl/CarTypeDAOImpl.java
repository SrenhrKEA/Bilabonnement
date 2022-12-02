package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.CarTypeDAO;
import com.srenhrkea.eksamensprojekte22.models.CarType;

import java.util.Collection;
import java.util.Optional;

public class CarTypeDAOImpl implements CarTypeDAO {
  @Override
  public Optional<CarType> get(Integer integer) {
    return Optional.empty();
  }

  @Override
  public Collection<CarType> getAll() {
    return null;
  }

  @Override
  public boolean save(CarType carType) {
    return false;
  }

  @Override
  public boolean update(CarType carType) {
    return false;
  }

  @Override
  public boolean delete(CarType carType) {
    return false;
  }
}
