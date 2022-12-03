package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.models.Car;
import com.srenhrkea.eksamensprojekte22.services.CarDAO;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CarDAOImpl implements CarDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Car> get(String id) {
    Car car = null;
    String sql = "SELECT *FROM car WHERE idCarVIN=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        String idCarVIN = rs.getString("idCarVIN");
        boolean isAvailable = rs.getBoolean("isAvailable");
        double initialKilometrage = rs.getDouble("initialKilometrage");
        String regNo = rs.getString("regNo");
        int idLease = rs.getInt("LeaseidLease");
        int idCarType = rs.getInt("CarTypeRefidCarTypeRef");

        car = new Car();
        car.setIdCarVIN(idCarVIN);
        car.setAvailable(isAvailable);
        car.setInitialKilometrage(initialKilometrage);
        car.setRegNo(regNo);
        car.setIdLease(idLease);
        car.setIdCarType(idCarType);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert car != null;
    return Optional.of(car);
  }

  @Override
  public Collection<Car> getAll() {

    List<Car> cars = new ArrayList<>();
    String sql = "SELECT *FROM car";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        String idCarVIN = rs.getString("idCarVIN");
        boolean isAvailable = rs.getBoolean("isAvailable");
        double initialKilometrage = rs.getDouble("initialKilometrage");
        String regNo = rs.getString("regNo");
        int idLease = rs.getInt("LeaseidLease");
        int idCarType = rs.getInt("CarTypeRefidCarTypeRef");

        Car car = new Car();
        car.setIdCarVIN(idCarVIN);
        car.setAvailable(isAvailable);
        car.setInitialKilometrage(initialKilometrage);
        car.setRegNo(regNo);
        car.setIdLease(idLease);
        car.setIdCarType(idCarType);

        cars.add(car);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return cars;
  }

  @Override
  public boolean save(Car car) {

    String sql = "INSERT INTO car (idCarVIN, isAvailable,initialKilometrage,regNo,LeaseidLease,CarTypeRefidCarTypeRef)VALUES(?,?,?,?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, car.getIdCarVIN());
      psts.setBoolean(2, car.isAvailable());
      psts.setDouble(3, car.getInitialKilometrage());
      psts.setString(4, car.getRegNo());
      psts.setInt(5, car.getIdLease());
      psts.setInt(6, car.getIdCarType());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Car is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(Car car) {

    String sql = "UPDATE car set idCarVIN=?, isAvailable=?, initialKilometrage=?, regNo=?, LeaseidLease=?, CarTypeRefidCarTypeRef=? WHERE idCarVIN=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, car.getIdCarVIN());
      psts.setBoolean(2, car.isAvailable());
      psts.setDouble(3, car.getInitialKilometrage());
      psts.setString(4, car.getRegNo());
      psts.setInt(5, car.getIdLease());
      psts.setInt(6, car.getIdCarType());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Car is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Car car) {

    String sql = "DELETE FROM car WHERE idCarVIN=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, car.getIdCarVIN());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Car Type Reference with ID " + car.getIdCarVIN() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
