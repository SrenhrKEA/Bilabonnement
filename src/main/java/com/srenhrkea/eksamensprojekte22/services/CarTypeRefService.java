package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.CarTypeRef;

import java.sql.SQLException;
import java.util.List;

public interface CarTypeRefService {

  CarTypeRef getCarTypeRefById(int id) throws Exception;

  List<CarTypeRef> getAllCarTypeRefs() throws SQLException;

  boolean saveCarTypeRef(CarTypeRef carTypeRef) throws SQLException;

  boolean updateCarTypeRef(CarTypeRef carTypeRef) throws SQLException;

  boolean deleteCarTypeRefById(int id) throws SQLException;

}
