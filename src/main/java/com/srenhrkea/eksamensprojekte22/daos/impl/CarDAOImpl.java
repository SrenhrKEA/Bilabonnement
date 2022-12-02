package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.CarDAO;
import com.srenhrkea.eksamensprojekte22.models.Car;

import java.util.Collection;
import java.util.Optional;

public class CarDAOImpl implements CarDAO {

  @Override
  public Optional<Car> get(String s) {
    return Optional.empty();
  }

  @Override
  public Collection<Car> getAll() {
    return null;
  }

  @Override
  public boolean save(Car car) {
    return false;
  }

  @Override
  public boolean update(Car car) {
    return false;
  }

  @Override
  public boolean delete(Car car) {
    return false;
  }
}
