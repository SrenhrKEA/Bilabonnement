package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.CarTypeRefDAO;
import com.srenhrkea.eksamensprojekte22.enums.FuelType;
import com.srenhrkea.eksamensprojekte22.enums.TransmissionType;
import com.srenhrkea.eksamensprojekte22.models.CarTypeRef;
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
public class CarTypeRefDAOImpl implements CarTypeRefDAO {
  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<CarTypeRef> get(Integer id) throws SQLException {
    CarTypeRef carTypeRef = null;
    String sql = "SELECT *FROM cartyperef WHERE idCarTypeRef=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idCarTypeRef = rs.getInt("idCarTypeRef");
      int seatingCapacity = rs.getInt("seatingCapacity");
      double taxableValue = rs.getDouble("taxableValue");
      double registrationTax = rs.getDouble("registrationTax");
      double fuelConsumption = rs.getDouble("fuelConsumption");
      double emission = rs.getDouble("emission");
      double pricePerMonth = rs.getDouble("pricePerMonth");
      String brand = rs.getString("brand");
      String model = rs.getString("model");
      String description = rs.getString("´description´");
      TransmissionType transmissionType = TransmissionType.valueOf(rs.getString("transmissionType"));
      FuelType fuelType = FuelType.valueOf(rs.getString("fuelType"));

      carTypeRef = new CarTypeRef();
      carTypeRef.setIdCarTypeRef(idCarTypeRef);
      carTypeRef.setSeatingCapacity(seatingCapacity);
      carTypeRef.setTaxableValue(taxableValue);
      carTypeRef.setRegistrationTax(registrationTax);
      carTypeRef.setFuelConsumption(fuelConsumption);
      carTypeRef.setEmission(emission);
      carTypeRef.setPricePerMonth(pricePerMonth);
      carTypeRef.setBrand(brand);
      carTypeRef.setModel(model);
      carTypeRef.setDescription(description);
      carTypeRef.setTransmissionType(transmissionType);
      carTypeRef.setFuelType(fuelType);
    }

    assert carTypeRef != null;
    return Optional.of(carTypeRef);
  }

  @Override
  public Collection<CarTypeRef> getAll() throws SQLException {

    List<CarTypeRef> carTypeRefs = new ArrayList<>();
    String sql = "SELECT *FROM cartyperef";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idCarTypeRef = rs.getInt("idCarTypeRef");
      int seatingCapacity = rs.getInt("seatingCapacity");
      double taxableValue = rs.getDouble("taxableValue");
      double registrationTax = rs.getDouble("registrationTax");
      double fuelConsumption = rs.getDouble("fuelConsumption");
      double emission = rs.getDouble("emission");
      double pricePerMonth = rs.getDouble("pricePerMonth");
      String brand = rs.getString("brand");
      String model = rs.getString("model");
      String description = rs.getString("´description´");
      TransmissionType transmissionType = TransmissionType.valueOf(rs.getString("transmissionType"));
      FuelType fuelType = FuelType.valueOf(rs.getString("fuelType"));

      CarTypeRef carTypeRef = new CarTypeRef();
      carTypeRef.setIdCarTypeRef(idCarTypeRef);
      carTypeRef.setSeatingCapacity(seatingCapacity);
      carTypeRef.setTaxableValue(taxableValue);
      carTypeRef.setRegistrationTax(registrationTax);
      carTypeRef.setFuelConsumption(fuelConsumption);
      carTypeRef.setEmission(emission);
      carTypeRef.setPricePerMonth(pricePerMonth);
      carTypeRef.setBrand(brand);
      carTypeRef.setModel(model);
      carTypeRef.setDescription(description);
      carTypeRef.setTransmissionType(transmissionType);
      carTypeRef.setFuelType(fuelType);

      carTypeRefs.add(carTypeRef);
    }

    return carTypeRefs;
  }

  @Override
  public boolean save(CarTypeRef carTypeRef) throws SQLException {

    String sql = "INSERT INTO cartyperef (seatingCapacity,taxableValue,registrationTax,fuelConsumption,emission,pricePerMonth,brand,model,´description´,transmissionType,fuelType)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, carTypeRef.getSeatingCapacity());
    psts.setDouble(2, carTypeRef.getTaxableValue());
    psts.setDouble(3, carTypeRef.getRegistrationTax());
    psts.setDouble(4, carTypeRef.getFuelConsumption());
    psts.setDouble(5, carTypeRef.getEmission());
    psts.setDouble(6, carTypeRef.getPricePerMonth());
    psts.setString(7, carTypeRef.getBrand());
    psts.setString(8, carTypeRef.getModel());
    psts.setString(9, carTypeRef.getDescription());
    psts.setString(10, String.valueOf(carTypeRef.getTransmissionType()));
    psts.setString(11, String.valueOf(carTypeRef.getFuelType()));

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Car Type Reference is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(CarTypeRef carTypeRef) throws SQLException {

    String sql = "UPDATE cartyperef set seatingCapacity=?, taxableValue=?, registrationTax=?, fuelConsumption=?, emission=?, pricePerMonth=?, brand=?, model=?, ´description´=?, transmissionType=?, fuelType=? WHERE idCarTypeRef=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, carTypeRef.getSeatingCapacity());
    psts.setDouble(2, carTypeRef.getTaxableValue());
    psts.setDouble(3, carTypeRef.getRegistrationTax());
    psts.setDouble(4, carTypeRef.getFuelConsumption());
    psts.setDouble(5, carTypeRef.getEmission());
    psts.setDouble(6, carTypeRef.getPricePerMonth());
    psts.setString(7, carTypeRef.getBrand());
    psts.setString(8, carTypeRef.getModel());
    psts.setString(9, carTypeRef.getDescription());
    psts.setString(10, String.valueOf(carTypeRef.getTransmissionType()));
    psts.setString(11, String.valueOf(carTypeRef.getFuelType()));
    psts.setInt(12, carTypeRef.getIdCarTypeRef());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Car Type Reference is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM cartyperef WHERE idCarTypeRef=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Car Type Reference with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
