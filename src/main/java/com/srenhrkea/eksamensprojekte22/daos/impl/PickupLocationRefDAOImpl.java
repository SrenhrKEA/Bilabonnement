package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.PickupLocationRefDAO;
import com.srenhrkea.eksamensprojekte22.models.PickupLocationRef;
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
public class PickupLocationRefDAOImpl implements PickupLocationRefDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<PickupLocationRef> get(Integer id) {
    PickupLocationRef pickupLocationRef = null;
    String sql = "SELECT *FROM pickuplocationref WHERE idPickupLocationRef=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idPickupLocationRef = rs.getInt("idPickupLocationRef");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int postalCode = rs.getInt("postalCode");

        pickupLocationRef = new PickupLocationRef();
        pickupLocationRef.setIdPickupLocationRef(idPickupLocationRef);
        pickupLocationRef.setAddress(address);
        pickupLocationRef.setCity(city);
        pickupLocationRef.setPostalCode(postalCode);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert pickupLocationRef != null;
    return Optional.of(pickupLocationRef);
  }

  @Override
  public Collection<PickupLocationRef> getAll() {

    List<PickupLocationRef> pickupLocationRefs = new ArrayList<>();
    String sql = "SELECT *FROM pickuplocationref";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idPickupLocationRef = rs.getInt("idPickupLocationRef");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int postalCode = rs.getInt("postalCode");

        PickupLocationRef pickupLocationRef = new PickupLocationRef();
        pickupLocationRef.setIdPickupLocationRef(idPickupLocationRef);
        pickupLocationRef.setAddress(address);
        pickupLocationRef.setCity(city);
        pickupLocationRef.setPostalCode(postalCode);

        pickupLocationRefs.add(pickupLocationRef);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return pickupLocationRefs;
  }

  @Override
  public boolean save(PickupLocationRef pickupLocationRef) {

    String sql = "INSERT INTO pickuplocationref(address,city,postalCode)VALUES(?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, pickupLocationRef.getAddress());
      psts.setString(2, pickupLocationRef.getCity());
      psts.setInt(3, pickupLocationRef.getPostalCode());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Location Reference is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(PickupLocationRef pickupLocationRef) {

    String sql = "UPDATE pickuplocationref set address=?, city=?, postalCode=? WHERE idPickupLocationRef=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setString(1, pickupLocationRef.getAddress());
      psts.setString(2, pickupLocationRef.getCity());
      psts.setInt(3, pickupLocationRef.getPostalCode());
      psts.setInt(4, pickupLocationRef.getIdPickupLocationRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Location Reference is updated.");
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
        System.out.println("Location Reference with ID " + id + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
