package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.DamageDAO;
import com.srenhrkea.eksamensprojekte22.models.Damage;

import java.util.Collection;
import java.util.Optional;

public class DamageDAOImpl implements DamageDAO {

  @Override
  public Optional<Damage> get(Integer integer) {
    return Optional.empty();
  }

  @Override
  public Collection<Damage> getAll() {
    return null;
  }

  @Override
  public boolean save(Damage damage) {
    return false;
  }

  @Override
  public boolean update(Damage damage) {
    return false;
  }

  @Override
  public boolean delete(Damage damage) {
    return false;
  }
}
