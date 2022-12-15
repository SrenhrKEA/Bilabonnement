package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.entities.KilometragePlan;

import java.sql.SQLException;
import java.util.Collection;


public interface KilometragePlanDAO extends GenericDAO<KilometragePlan, Integer> {
  Collection<KilometragePlan> getAllByIdLease(Integer id) throws SQLException;
  Collection<KilometragePlan> getAllByIdKilometragePlanRef(Integer id) throws SQLException;
}
