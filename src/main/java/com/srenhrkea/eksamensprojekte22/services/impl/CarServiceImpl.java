package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CarDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Car;
import com.srenhrkea.eksamensprojekte22.services.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

  private CarDAOImpl carDAO;

  public CarServiceImpl(CarDAOImpl carDAO) {
    this.carDAO = carDAO;
  }

  @Override
  public Car getCarById(String id) {
    Optional<Car> optional = carDAO.get(id);
    Car car;
    if (optional.isPresent()) {
      car = optional.get();
    } else {
      throw new RuntimeException(" Car with VIN: " + id + " does not exist");
    }
    return car;
  }

  @Override
  public List<Car> getAllCars() {
    return (List<Car>) carDAO.getAll();
  }

  @Override
  public List<Car> getAllCarsByIdLease(int id) {
    return (List<Car>) carDAO.getAllByIdLease(id);
  }

  @Override
  public List<Car> getAllCarsByIdCarTypeRef(int id) {
    return (List<Car>) carDAO.getAllByIdCarTypeRef(id);
  }

  @Override
  public void saveCar(Car car) {
    this.carDAO.save(car);
  }

  @Override
  public void updateCar(Car car) {
    String idCar = car.getIdCarVIN();
    Optional<Car> optional = carDAO.get(idCar);
    if (optional.isPresent()) {
      carDAO.update(car);
    } else {
      throw new RuntimeException(" Car with VIN: " + idCar + " does not exist");
    }
  }

  @Override
  public void deleteCarById(String id) {
    Optional<Car> optional = carDAO.get(id);
    if (optional.isPresent()) {
      this.carDAO.delete(id);
    } else {
      throw new RuntimeException(" Car with VIN: " + id + " does not exist");
    }
  }
}
