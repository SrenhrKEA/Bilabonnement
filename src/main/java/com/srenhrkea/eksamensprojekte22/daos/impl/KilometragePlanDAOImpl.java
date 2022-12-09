package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.KilometragePlanDAO;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;
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
public class KilometragePlanDAOImpl implements KilometragePlanDAO {
  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<KilometragePlan> get(Integer id) throws SQLException {
    KilometragePlan kilometragePlan = null;
    String sql = "SELECT *FROM kilometrageplan WHERE idKilometragePlan=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idKilometragePlan = rs.getInt("idKilometragePlan");
      int idKilometragePlanRef = rs.getInt("KilometragePlanRefidKilometragePlanRef");
      int idLease = rs.getInt("LeaseidLease");

      kilometragePlan = new KilometragePlan();
      kilometragePlan.setIdKilometragePlan(idKilometragePlan);
      kilometragePlan.setIdKilometragePlanRef(idKilometragePlanRef);
      kilometragePlan.setIdLease(idLease);

    }

    assert kilometragePlan != null;
    return Optional.of(kilometragePlan);
  }

  @Override
  public Collection<KilometragePlan> getAll() throws SQLException {

    List<KilometragePlan> kilometragePlans = new ArrayList<>();
    String sql = "SELECT *FROM kilometrageplan";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idKilometragePlan = rs.getInt("idKilometragePlan");
      int idKilometragePlanRef = rs.getInt("KilometragePlanRefidKilometragePlanRef");
      int idLease = rs.getInt("LeaseidLease");

      KilometragePlan kilometragePlan = new KilometragePlan();
      kilometragePlan.setIdKilometragePlan(idKilometragePlan);
      kilometragePlan.setIdKilometragePlanRef(idKilometragePlanRef);
      kilometragePlan.setIdLease(idLease);

      kilometragePlans.add(kilometragePlan);
    }

    return kilometragePlans;
  }

  @Override
  public Collection<KilometragePlan> getAllByIdLease(Integer id) throws SQLException {

    List<KilometragePlan> kilometragePlans = new ArrayList<>();
    String sql = "SELECT *FROM kilometrageplan WHERE LeaseidLease=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idKilometragePlan = rs.getInt("idKilometragePlan");
      int idKilometragePlanRef = rs.getInt("KilometragePlanRefidKilometragePlanRef");
      int idLease = rs.getInt("LeaseidLease");

      KilometragePlan kilometragePlan = new KilometragePlan();
      kilometragePlan.setIdKilometragePlan(idKilometragePlan);
      kilometragePlan.setIdKilometragePlanRef(idKilometragePlanRef);
      kilometragePlan.setIdLease(idLease);

      kilometragePlans.add(kilometragePlan);
    }

    return kilometragePlans;
  }

  @Override
  public Collection<KilometragePlan> getAllByIdKilometragePlanRef(Integer id) throws SQLException {

    List<KilometragePlan> kilometragePlans = new ArrayList<>();
    String sql = "SELECT *FROM kilometrageplan WHERE KilometragePlanRefidKilometragePlanRef=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idKilometragePlan = rs.getInt("idKilometragePlan");
      int idKilometragePlanRef = rs.getInt("KilometragePlanRefidKilometragePlanRef");
      int idLease = rs.getInt("LeaseidLease");

      KilometragePlan kilometragePlan = new KilometragePlan();
      kilometragePlan.setIdKilometragePlan(idKilometragePlan);
      kilometragePlan.setIdKilometragePlanRef(idKilometragePlanRef);
      kilometragePlan.setIdLease(idLease);

      kilometragePlans.add(kilometragePlan);
    }

    return kilometragePlans;
  }

  @Override
  public boolean save(KilometragePlan kilometragePlan) throws SQLException {

    String sql = "INSERT INTO kilometrageplan(LeaseidLease,KilometragePlanRefidKilometragePlanRef)VALUES(?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, kilometragePlan.getIdLease());
    psts.setInt(2, kilometragePlan.getIdKilometragePlanRef());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Kilometrage Plan is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(KilometragePlan kilometragePlan) throws SQLException {

    String sql = "UPDATE kilometrageplan set LeaseidLease=?, KilometragePlanRefidKilometragePlanRef=? WHERE idKilometragePlan=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, kilometragePlan.getIdLease());
    psts.setInt(2, kilometragePlan.getIdKilometragePlanRef());
    psts.setInt(3, kilometragePlan.getIdKilometragePlan());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Kilometrage Plan is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM kilometrageplan WHERE idKilometragePlan=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Kilometrage Plan with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
