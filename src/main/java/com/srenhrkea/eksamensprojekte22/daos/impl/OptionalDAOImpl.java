package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.OptionalDAO;
import com.srenhrkea.eksamensprojekte22.models.Optional;

import java.util.Collection;

public class OptionalDAOImpl implements OptionalDAO {
  @Override
  public java.util.Optional<Optional> get(Integer integer) {
    return java.util.Optional.empty();
  }

  @Override
  public Collection<Optional> getAll() {
    return null;
  }

  @Override
  public boolean save(Optional optional) {
    return false;
  }

  @Override
  public boolean update(Optional optional) {
    return false;
  }

  @Override
  public boolean delete(Optional optional) {
    return false;
  }
}
