package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.models.PickupLocation;

import java.util.Collection;


public interface PickupLocationDAO extends GenericDAO<PickupLocation, Integer> {
  Collection<PickupLocation> getAllByIdLease(Integer id);
  Collection<PickupLocation> getAllByIdPickupLocationRef(Integer id);
}
