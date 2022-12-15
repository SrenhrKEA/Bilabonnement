package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {

  Car getCarById(String id) throws Exception;

  List<Car> getAllCars() throws SQLException;

  List<Car> getAllCarsByIdCarTypeRef(int id) throws SQLException;

  List<Car> getAllCarsByIsAvailable() throws SQLException;

  List<Car> getAllCarsByIsNotAvailable() throws SQLException;

  boolean saveCar(Car car) throws SQLException;

  boolean updateCar(Car car) throws SQLException;

  boolean deleteCarById(String id) throws SQLException;

  double GetIncomePerMonth() throws SQLException;
}
