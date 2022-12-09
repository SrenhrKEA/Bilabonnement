package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {

  Car getCarById(String id) throws Exception;

  List<Car> getAllCars() throws SQLException;

  List<Car> getAllCarsByIdCarTypeRef(int id) throws SQLException;

  boolean saveCar(Car car) throws SQLException;

  boolean updateCar(Car car) throws SQLException;

  boolean deleteCarById(String id) throws SQLException;

}
