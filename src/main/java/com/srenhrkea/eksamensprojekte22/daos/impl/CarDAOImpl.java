package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.CarDAO;
import com.srenhrkea.eksamensprojekte22.models.Car;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDAOImpl implements CarDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Car> get(String id) throws SQLException {
    Car car = null;
    String sql = "SELECT *FROM car WHERE idCarVIN=?";

    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setString(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      String idCarVIN = rs.getString("idCarVIN");
      boolean isAvailable = rs.getBoolean("isAvailable");
      double initialKilometrage = rs.getDouble("initialKilometrage");
      String regNo = rs.getString("regNo");
      int idCarTypeRef = rs.getInt("CarTypeRefidCarTypeRef");

      car = new Car();
      car.setIdCarVIN(idCarVIN);
      car.setAvailable(isAvailable);
      car.setInitialKilometrage(initialKilometrage);
      car.setRegNo(regNo);
      car.setIdCarTypeRef(idCarTypeRef);
    }

    assert car != null;
    return Optional.of(car);
  }

  @Override
  public Collection<Car> getAll() throws SQLException {

    List<Car> cars = new ArrayList<>();
    String sql = "SELECT *FROM car";
    PreparedStatement psts = conn.prepareStatement(sql);
    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      String idCarVIN = rs.getString("idCarVIN");
      boolean isAvailable = rs.getBoolean("isAvailable");
      double initialKilometrage = rs.getDouble("initialKilometrage");
      String regNo = rs.getString("regNo");
      int idCarTypeRef = rs.getInt("CarTypeRefidCarTypeRef");

      Car car = new Car();
      car.setIdCarVIN(idCarVIN);
      car.setAvailable(isAvailable);
      car.setInitialKilometrage(initialKilometrage);
      car.setRegNo(regNo);
      car.setIdCarTypeRef(idCarTypeRef);

      cars.add(car);
    }

    return cars;
  }

  @Override
  public Collection<Car> getAllByIdCarTypeRef(Integer id) throws SQLException {

    List<Car> cars = new ArrayList<>();
    String sql = "SELECT *FROM car WHERE idCarVIN=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      String idCarVIN = rs.getString("idCarVIN");
      boolean isAvailable = rs.getBoolean("isAvailable");
      double initialKilometrage = rs.getDouble("initialKilometrage");
      String regNo = rs.getString("regNo");
      int idCarTypeRef = rs.getInt("CarTypeRefidCarTypeRef");

      Car car = new Car();
      car.setIdCarVIN(idCarVIN);
      car.setAvailable(isAvailable);
      car.setInitialKilometrage(initialKilometrage);
      car.setRegNo(regNo);
      car.setIdCarTypeRef(idCarTypeRef);

      cars.add(car);
    }
    return cars;
  }

  @Override
  public Collection<Car> getAllByIsAvailable() throws SQLException {

    List<Car> cars = new ArrayList<>();
    String sql = "SELECT *FROM car WHERE isAvailable=1";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      String idCarVIN = rs.getString("idCarVIN");
      boolean isAvailable = rs.getBoolean("isAvailable");
      double initialKilometrage = rs.getDouble("initialKilometrage");
      String regNo = rs.getString("regNo");
      int idCarTypeRef = rs.getInt("CarTypeRefidCarTypeRef");

      Car car = new Car();
      car.setIdCarVIN(idCarVIN);
      car.setAvailable(isAvailable);
      car.setInitialKilometrage(initialKilometrage);
      car.setRegNo(regNo);
      car.setIdCarTypeRef(idCarTypeRef);

      cars.add(car);
    }
    return cars;
  }

  @Override
  public Collection<Car> getAllByIsNotAvailable() throws SQLException {

    List<Car> cars = new ArrayList<>();
    String sql = "SELECT *FROM car WHERE isAvailable=0";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      String idCarVIN = rs.getString("idCarVIN");
      boolean isAvailable = rs.getBoolean("isAvailable");
      double initialKilometrage = rs.getDouble("initialKilometrage");
      String regNo = rs.getString("regNo");
      int idCarTypeRef = rs.getInt("CarTypeRefidCarTypeRef");

      Car car = new Car();
      car.setIdCarVIN(idCarVIN);
      car.setAvailable(isAvailable);
      car.setInitialKilometrage(initialKilometrage);
      car.setRegNo(regNo);
      car.setIdCarTypeRef(idCarTypeRef);

      cars.add(car);
    }
    return cars;
  }

  @Override
  public boolean save(Car car) throws SQLException {

    String sql = "INSERT INTO car (idCarVIN, isAvailable,initialKilometrage,regNo,CarTypeRefidCarTypeRef)VALUES(?,?,?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, car.getIdCarVIN());
    psts.setBoolean(2, car.isAvailable());
    psts.setDouble(3, car.getInitialKilometrage());
    psts.setString(4, car.getRegNo());
    psts.setInt(5, car.getIdCarTypeRef());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Car is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(Car car) throws SQLException {

    String sql = "UPDATE car set isAvailable=?, initialKilometrage=?, regNo=?, CarTypeRefidCarTypeRef=? WHERE idCarVIN=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setBoolean(1, car.isAvailable());
    psts.setDouble(2, car.getInitialKilometrage());
    psts.setString(3, car.getRegNo());
    psts.setInt(4, car.getIdCarTypeRef());
    psts.setString(5, car.getIdCarVIN());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Car is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(String id) throws SQLException {

    String sql = "DELETE FROM car WHERE idCarVIN=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Car Type Reference with ID " + id + " is deleted.::");
      return true;
    }


    return false;
  }
}
