package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.PickupLocationDAO;
import com.srenhrkea.eksamensprojekte22.models.PickupLocation;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PickupLocationDAOImpl implements PickupLocationDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<PickupLocation> get(Integer id) {
    PickupLocation pickupLocation = null;
    String sql = "SELECT *FROM pickuplocation WHERE idPickupLocation=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idPickupLocation = rs.getInt("idPickupLocation");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int postalCode = rs.getInt("postalCode");

        pickupLocation = new PickupLocation();
        pickupLocation.setIdPickupLocation(idPickupLocation);
        pickupLocation.setAddress(address);
        pickupLocation.setCity(city);
        pickupLocation.setPostalCode(postalCode);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert pickupLocation != null;
    return Optional.of(pickupLocation);
  }

  @Override
  public Collection<PickupLocation> getAll() {

    List<PickupLocation> pickupLocations = new ArrayList<>();
    String sql = "SELECT *FROM pickuplocation";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idPickupLocation = rs.getInt("idPickupLocation");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int postalCode = rs.getInt("postalCode");

        PickupLocation pickupLocation = new PickupLocation();
        pickupLocation.setIdPickupLocation(idPickupLocation);
        pickupLocation.setAddress(address);
        pickupLocation.setCity(city);
        pickupLocation.setPostalCode(postalCode);

        pickupLocations.add(pickupLocation);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pickupLocations;
  }

  @Override
  public boolean save(PickupLocation pickupLocation) {
    return false;
  }

  @Override
  public boolean update(PickupLocation pickupLocation) {
    return false;
  }

  @Override
  public boolean delete(PickupLocation pickupLocation) {

    String sql = "DELETE FROM pickuplocation WHERE idPickupLocation=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, pickupLocation.getIdPickupLocation());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Location with ID " + pickupLocation.getIdPickupLocation() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
