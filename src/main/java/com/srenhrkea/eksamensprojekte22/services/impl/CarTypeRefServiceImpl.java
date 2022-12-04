package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CarTypeRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.CarTypeRef;
import com.srenhrkea.eksamensprojekte22.services.CarTypeRefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarTypeRefServiceImpl implements CarTypeRefService {

  private CarTypeRefDAOImpl carTypeRefDAO;

  public CarTypeRefServiceImpl(CarTypeRefDAOImpl carTypeRefDAO) {
    this.carTypeRefDAO = carTypeRefDAO;
  }


  @Override
  public CarTypeRef getCarTypeRefById(int id) {
    Optional<CarTypeRef> optional = carTypeRefDAO.get(id);
    CarTypeRef carTypeRef;
    if (optional.isPresent()) {
      carTypeRef = optional.get();
    } else {
      throw new RuntimeException(" CarTypeRef with ID: " + id + " does not exist");
    }
    return carTypeRef;
  }

  @Override
  public List<CarTypeRef> getAllCarTypeRefs() {
    return (List<CarTypeRef>) carTypeRefDAO.getAll();
  }

  @Override
  public void saveCarTypeRef(CarTypeRef carTypeRef) {
    this.carTypeRefDAO.save(carTypeRef);
  }

  @Override
  public void updateCarTypeRef(CarTypeRef carTypeRef) {
    int idCarTypeRef = carTypeRef.getIdCarTypeRef();
    Optional<CarTypeRef> optional = carTypeRefDAO.get(idCarTypeRef);
    if (optional.isPresent()) {
      carTypeRefDAO.update(carTypeRef);
    } else {
      throw new RuntimeException(" CarTypeRef with ID: " + idCarTypeRef + " does not exist");
    }
  }

  @Override
  public void deleteCarTypeRefById(int id) {
    Optional<CarTypeRef> optional = carTypeRefDAO.get(id);
    if (optional.isPresent()) {
      this.carTypeRefDAO.delete(id);
    } else {
      throw new RuntimeException(" CarTypeRef with ID: " + id + " does not exist");
    }
  }
}
