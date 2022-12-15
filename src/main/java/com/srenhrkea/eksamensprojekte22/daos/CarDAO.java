package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.entities.Car;

import java.sql.SQLException;
import java.util.Collection;

public interface CarDAO extends GenericDAO<Car, String> {

  Collection<Car> getAllByIdCarTypeRef(Integer id) throws SQLException;

  Collection<Car> getAllByIsAvailable() throws SQLException;

  Collection<Car> getAllByIsNotAvailable() throws SQLException;
}
