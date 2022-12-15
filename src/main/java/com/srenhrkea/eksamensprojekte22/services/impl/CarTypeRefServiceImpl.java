package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CarTypeRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.CarTypeRef;
import com.srenhrkea.eksamensprojekte22.services.CarTypeRefService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CarTypeRefServiceImpl implements CarTypeRefService {

  private CarTypeRefDAOImpl carTypeRefDAO;

  public CarTypeRefServiceImpl(CarTypeRefDAOImpl carTypeRefDAO) {
    this.carTypeRefDAO = carTypeRefDAO;
  }


  @Override
  public CarTypeRef getCarTypeRefById(int id) throws Exception {
    Optional<CarTypeRef> carTypeRef = carTypeRefDAO.get(id);
    return carTypeRef.orElseThrow(
        () -> new Exception("A carTypeRef with ID: " + id + ", does not exist."));
  }

  @Override
  public List<CarTypeRef> getAllCarTypeRefs() throws SQLException {
    return (List<CarTypeRef>) carTypeRefDAO.getAll();
  }

  @Override
  public boolean saveCarTypeRef(CarTypeRef carTypeRef) throws SQLException {
    return carTypeRefDAO.save(carTypeRef);
  }

  @Override
  public boolean updateCarTypeRef(CarTypeRef carTypeRef) throws SQLException {
    return carTypeRefDAO.update(carTypeRef);
  }

  @Override
  public boolean deleteCarTypeRefById(int id) throws SQLException {
    return carTypeRefDAO.delete(id);
  }
}
