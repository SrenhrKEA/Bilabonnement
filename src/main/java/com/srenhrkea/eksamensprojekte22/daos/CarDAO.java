package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.models.Car;

import java.util.Collection;

public interface CarDAO extends GenericDAO<Car, String> {

  Collection<Car> getAllByIdLease(Integer id);
  Collection<Car> getAllByIdCarTypeRef(Integer id);
}
