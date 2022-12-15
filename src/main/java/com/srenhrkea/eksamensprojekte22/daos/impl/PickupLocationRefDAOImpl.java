package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.PickupLocationRefDAO;
import com.srenhrkea.eksamensprojekte22.entities.PickupLocationRef;
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
public class PickupLocationRefDAOImpl implements PickupLocationRefDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<PickupLocationRef> get(Integer id) throws SQLException {
    PickupLocationRef pickupLocationRef = null;
    String sql = "SELECT *FROM pickuplocationref WHERE idPickupLocationRef=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idPickupLocationRef = rs.getInt("idPickupLocationRef");
      String address = rs.getString("address");
      String city = rs.getString("city");
      int postalCode = rs.getInt("postalCode");
      String title = rs.getString("title");

      pickupLocationRef = new PickupLocationRef();
      pickupLocationRef.setIdPickupLocationRef(idPickupLocationRef);
      pickupLocationRef.setAddress(address);
      pickupLocationRef.setCity(city);
      pickupLocationRef.setPostalCode(postalCode);
      pickupLocationRef.setTitle(title);
    }

    assert pickupLocationRef != null;
    return Optional.of(pickupLocationRef);
  }

  @Override
  public Collection<PickupLocationRef> getAll() throws SQLException {

    List<PickupLocationRef> pickupLocationRefs = new ArrayList<>();
    String sql = "SELECT *FROM pickuplocationref";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idPickupLocationRef = rs.getInt("idPickupLocationRef");
      String address = rs.getString("address");
      String city = rs.getString("city");
      int postalCode = rs.getInt("postalCode");
      String title = rs.getString("title");

      PickupLocationRef pickupLocationRef = new PickupLocationRef();
      pickupLocationRef.setIdPickupLocationRef(idPickupLocationRef);
      pickupLocationRef.setAddress(address);
      pickupLocationRef.setCity(city);
      pickupLocationRef.setPostalCode(postalCode);
      pickupLocationRef.setTitle(title);

      pickupLocationRefs.add(pickupLocationRef);
    }

    return pickupLocationRefs;
  }

  @Override
  public boolean save(PickupLocationRef pickupLocationRef) throws SQLException {

    String sql = "INSERT INTO pickuplocationref(address,city,postalCode, title)VALUES(?,?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, pickupLocationRef.getAddress());
    psts.setString(2, pickupLocationRef.getCity());
    psts.setInt(3, pickupLocationRef.getPostalCode());
    psts.setString(4, pickupLocationRef.getTitle());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Location Reference is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(PickupLocationRef pickupLocationRef) throws SQLException {

    String sql = "UPDATE pickuplocationref set address=?, city=?, postalCode=?, title=? WHERE idPickupLocationRef=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, pickupLocationRef.getAddress());
    psts.setString(2, pickupLocationRef.getCity());
    psts.setInt(3, pickupLocationRef.getPostalCode());
    psts.setString(4, pickupLocationRef.getTitle());
    psts.setInt(5, pickupLocationRef.getIdPickupLocationRef());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Location Reference is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM pickuplocation WHERE idPickupLocation=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Location Reference with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
