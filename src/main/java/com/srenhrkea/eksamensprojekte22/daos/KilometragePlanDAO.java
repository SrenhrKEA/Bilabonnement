package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;

import java.util.Collection;


public interface KilometragePlanDAO extends GenericDAO<KilometragePlan, Integer> {
  Collection<KilometragePlan> getAllByIdLease(Integer id);
  Collection<KilometragePlan> getAllByIdKilometragePlanRef(Integer id);
}
