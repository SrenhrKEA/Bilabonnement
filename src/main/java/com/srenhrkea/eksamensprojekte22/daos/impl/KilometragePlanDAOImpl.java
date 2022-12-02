package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.KilometragePlanDAO;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;

import java.util.Collection;
import java.util.Optional;

public class KilometragePlanDAOImpl implements KilometragePlanDAO {

  @Override
  public Optional<KilometragePlan> get(Integer integer) {
    return Optional.empty();
  }

  @Override
  public Collection<KilometragePlan> getAll() {
    return null;
  }

  @Override
  public boolean save(KilometragePlan kilometragePlan) {
    return false;
  }

  @Override
  public boolean update(KilometragePlan kilometragePlan) {
    return false;
  }

  @Override
  public boolean delete(KilometragePlan kilometragePlan) {
    return false;
  }
}
