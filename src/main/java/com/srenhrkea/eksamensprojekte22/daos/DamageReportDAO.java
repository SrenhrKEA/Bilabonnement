package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.entities.DamageReport;

import java.sql.SQLException;
import java.util.Collection;

public interface DamageReportDAO extends GenericDAO<DamageReport, Integer> {
  Collection<DamageReport> getAllByIdCarVIN(String id) throws SQLException;
}
