package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.PickupLocationDAO;
import com.srenhrkea.eksamensprojekte22.models.PickupLocation;
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
        int idPickupLocationRef = rs.getInt("PickupLocationRefidPickupLocationRef");
        int idLease = rs.getInt("LeaseidLease");


        pickupLocation = new PickupLocation();
        pickupLocation.setIdPickupLocation(idPickupLocation);
        pickupLocation.setIdPickupLocationRef(idPickupLocationRef);
        pickupLocation.setIdPickupLocation(idLease);
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
        int idPickupLocationRef = rs.getInt("PickupLocationRefidPickupLocationRef");
        int idLease = rs.getInt("LeaseidLease");


        PickupLocation pickupLocation = new PickupLocation();
        pickupLocation.setIdPickupLocation(idPickupLocation);
        pickupLocation.setIdPickupLocationRef(idPickupLocationRef);
        pickupLocation.setIdPickupLocation(idLease);


        pickupLocations.add(pickupLocation);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pickupLocations;
  }

  @Override
  public Collection<PickupLocation> getAllByIdLease(Integer id) {

    List<PickupLocation> pickupLocations = new ArrayList<>();
    String sql = "SELECT *FROM pickuplocation WHERE LeaseidLease=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {
      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idPickupLocation = rs.getInt("idPickupLocation");
        int idPickupLocationRef = rs.getInt("PickupLocationRefidPickupLocationRef");
        int idLease = rs.getInt("LeaseidLease");

        PickupLocation pickupLocation = new PickupLocation();
        pickupLocation.setIdPickupLocation(idPickupLocation);
        pickupLocation.setIdPickupLocationRef(idPickupLocationRef);
        pickupLocation.setIdPickupLocation(idLease);


        pickupLocations.add(pickupLocation);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pickupLocations;
  }

  @Override
  public Collection<PickupLocation> getAllByIdPickupLocationRef(Integer id) {

    List<PickupLocation> pickupLocations = new ArrayList<>();
    String sql = "SELECT *FROM pickuplocation WHERE PickupLocationRefidPickupLocationRef=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {
      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idPickupLocation = rs.getInt("idPickupLocation");
        int idPickupLocationRef = rs.getInt("PickupLocationRefidPickupLocationRef");
        int idLease = rs.getInt("LeaseidLease");

        PickupLocation pickupLocation = new PickupLocation();
        pickupLocation.setIdPickupLocation(idPickupLocation);
        pickupLocation.setIdPickupLocationRef(idPickupLocationRef);
        pickupLocation.setIdPickupLocation(idLease);


        pickupLocations.add(pickupLocation);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pickupLocations;
  }

  @Override
  public boolean save(PickupLocation pickupLocation) {

    String sql = "INSERT INTO pickuplocation(LeaseidLease,PickupLocationRefidPickupLocationRef)VALUES(?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, pickupLocation.getIdLease());
      psts.setInt(2, pickupLocation.getIdPickupLocationRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Location is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(PickupLocation pickupLocation) {

    String sql = "UPDATE pickuplocation set LeaseidLease=?, PickupLocationRefidPickupLocationRef=? WHERE idPickupLocation=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, pickupLocation.getIdLease());
      psts.setInt(2, pickupLocation.getIdPickupLocationRef());
      psts.setInt(3, pickupLocation.getIdPickupLocation());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Location is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Integer id) {

    String sql = "DELETE FROM pickuplocation WHERE idPickupLocation=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Location with ID " + id + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
