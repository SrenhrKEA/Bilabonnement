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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public class CarTypeRefDAOImpl implements CarTypeRefDAO {
  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<CarTypeRef> get(Integer id) {
    CarTypeRef carTypeRef = null;
    String sql = "SELECT *FROM cartyperef WHERE idCarTypeRef=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idCarType = rs.getInt("idCarType");
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
        carTypeRef.setIdCarType(idCarType);
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

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert carTypeRef != null;
    return Optional.of(carTypeRef);
  }

  @Override
  public Collection<CarTypeRef> getAll() {

    List<CarTypeRef> carTypes = new ArrayList<>();
    String sql = "SELECT *FROM cartyperef";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idCarType = rs.getInt("idCarType");
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

        CarTypeRef carType = new CarTypeRef();
        carType.setIdCarType(idCarType);
        carType.setSeatingCapacity(seatingCapacity);
        carType.setTaxableValue(taxableValue);
        carType.setRegistrationTax(registrationTax);
        carType.setFuelConsumption(fuelConsumption);
        carType.setEmission(emission);
        carType.setPricePerMonth(pricePerMonth);
        carType.setBrand(brand);
        carType.setModel(model);
        carType.setDescription(description);
        carType.setTransmissionType(transmissionType);
        carType.setFuelType(fuelType);

        carTypes.add(carType);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return carTypes;
  }

  @Override
  public boolean save(CarTypeRef carTypeRef) {

    String sql = "INSERT INTO cartyperef (seatingCapacity,taxableValue,registrationTax,fuelConsumption,emission,pricePerMonth,brand,model,´description´,transmissionType,fuelType)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

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
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(CarTypeRef carTypeRef) {

    String sql = "UPDATE cartyperef set seatingCapacity=?, taxableValue=?, registrationTax=?, fuelConsumption=?, emission=?, pricePerMonth=?, brand=?, model=?, ´description´=?, transmissionType=?, fuelType=? WHERE idCarTypeRef=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

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
        System.out.println("Car Type Reference is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Integer id) {

    String sql = "DELETE FROM cartyperef WHERE idCarTypeRef=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Car Type Reference with ID " + id + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
