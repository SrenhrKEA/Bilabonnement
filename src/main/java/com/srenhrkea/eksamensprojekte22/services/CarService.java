package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Car;

import java.util.List;

public interface CarService {

  Car getCarById(String id);

  List<Car> getAllCars();

  List<Car> getAllCarsByIdLease(int id);

  List<Car> getAllCarsByIdCarTypeRef(int id);

  void saveCar(Car car);

  void updateCar(Car car, String id);

  void deleteCarById(String id);

}
