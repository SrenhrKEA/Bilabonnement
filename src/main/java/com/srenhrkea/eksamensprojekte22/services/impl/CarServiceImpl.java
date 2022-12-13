package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CarDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.CarTypeRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Car;
import com.srenhrkea.eksamensprojekte22.models.CarTypeRef;
import com.srenhrkea.eksamensprojekte22.services.CarService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

  private CarDAOImpl carDAO;
  private CarTypeRefDAOImpl carTypeRefDAO;

  public CarServiceImpl(CarDAOImpl carDAO, CarTypeRefDAOImpl carTypeRefDAO) {
    this.carDAO = carDAO;
    this.carTypeRefDAO = carTypeRefDAO;
  }

  @Override
  public Car getCarById(String id) throws Exception {
    Optional<Car> car = carDAO.get(id);
    return car.orElseThrow(
        () -> new Exception("A car with ID: " + id + ", does not exist."));
  }

  @Override
  public List<Car> getAllCars() throws SQLException {
    return (List<Car>) carDAO.getAll();
  }

  @Override
  public List<Car> getAllCarsByIdCarTypeRef(int id) throws SQLException {
    return (List<Car>) carDAO.getAllByIdCarTypeRef(id);
  }

  @Override
  public List<Car> getAllCarsByIsAvailable() throws SQLException {
    return (List<Car>) carDAO.getAllByIsAvailable();
  }

  @Override
  public List<Car> getAllCarsByIsNotAvailable() throws SQLException {
    return (List<Car>) carDAO.getAllByIsNotAvailable();
  }

  @Override
  public boolean saveCar(Car car) throws SQLException {
    return carDAO.save(car);
  }

  @Override
  public boolean updateCar(Car car) throws SQLException {
    return carDAO.update(car);
  }

  @Override
  public boolean deleteCarById(String id) throws SQLException {
    return carDAO.delete(id);
  }

  @Override
  public double GetIncomePerMonth() throws SQLException {
    double income = 0;
    List<Car> cars = getAllCarsByIsNotAvailable();
    for (Car car : cars) {
      int idCarTyperef = car.getIdCarTypeRef();
      Optional<CarTypeRef> carTypeRef = carTypeRefDAO.get(idCarTyperef);
      if (carTypeRef.isPresent()) {
        income = income + carTypeRef.get().getPricePerMonth();
      }
    }
    return income;
  }

}
