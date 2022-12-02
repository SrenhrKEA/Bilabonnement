package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.DamageReportDAO;
import com.srenhrkea.eksamensprojekte22.models.DamageReport;

import java.util.Collection;
import java.util.Optional;

public class DamageReportDAOImpl implements DamageReportDAO {

  @Override
  public Optional<DamageReport> get(Integer integer) {
    return Optional.empty();
  }

  @Override
  public Collection<DamageReport> getAll() {
    return null;
  }

  @Override
  public boolean save(DamageReport damageReport) {
    return false;
  }

  @Override
  public boolean update(DamageReport damageReport) {
    return false;
  }

  @Override
  public boolean delete(DamageReport damageReport) {
    return false;
  }
}
