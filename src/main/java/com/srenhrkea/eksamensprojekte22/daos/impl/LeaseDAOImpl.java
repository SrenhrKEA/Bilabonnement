package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.LeaseDAO;
import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;
import com.srenhrkea.eksamensprojekte22.models.Lease;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class LeaseDAOImpl implements LeaseDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Lease> get(Integer id) throws SQLException {
    Lease lease = null;
    String sql = "SELECT *FROM lease WHERE idLease=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idLease = rs.getInt("idLease");
      int durationMonths = rs.getInt("durationMonths");
      int idCustomer = rs.getInt("CustomeridCustomer");
      Date dateOfRent = rs.getDate("dateOfRent");
      Date dateOfReturn = rs.getDate("dateOfReturn");
      SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));
      String idCarVIN = rs.getString("CaridCarVIN");

      lease = new Lease();
      lease.setIdLease(idLease);
      lease.setDurationMonths(durationMonths);
      lease.setIdCustomer(idCustomer);
      lease.setDateOfRent(dateOfRent);
      lease.setDateOfReturn(dateOfReturn);
      lease.setSubscriptionType(subscriptionType);
      lease.setIdCarVIN(idCarVIN);
    }

    assert lease != null;
    return Optional.of(lease);
  }

  @Override
  public Collection<Lease> getAll() throws SQLException {

    List<Lease> leases = new ArrayList<>();
    String sql = "SELECT *FROM lease";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idLease = rs.getInt("idLease");
      int durationMonths = rs.getInt("durationMonths");
      int idCustomer = rs.getInt("CustomeridCustomer");
      Date dateOfRent = rs.getDate("dateOfRent");
      Date dateOfReturn = rs.getDate("dateOfReturn");
      SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));
      String idCarVIN = rs.getString("CaridCarVIN");

      Lease lease = new Lease();
      lease.setIdLease(idLease);
      lease.setDurationMonths(durationMonths);
      lease.setIdCustomer(idCustomer);
      lease.setDateOfRent(dateOfRent);
      lease.setDateOfReturn(dateOfReturn);
      lease.setSubscriptionType(subscriptionType);
      lease.setIdCarVIN(idCarVIN);

      leases.add(lease);
    }

    return leases;
  }

  @Override
  public Collection<Lease> getAllByIdCustomer(Integer id) throws SQLException {

    List<Lease> leases = new ArrayList<>();
    String sql = "SELECT *FROM lease WHERE CustomeridCustomer=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idLease = rs.getInt("idLease");
      int durationMonths = rs.getInt("durationMonths");
      int idCustomer = rs.getInt("CustomeridCustomer");
      Date dateOfRent = rs.getDate("dateOfRent");
      Date dateOfReturn = rs.getDate("dateOfReturn");
      SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));
      String idCarVIN = rs.getString("CaridCarVIN");

      Lease lease = new Lease();
      lease.setIdLease(idLease);
      lease.setDurationMonths(durationMonths);
      lease.setIdCustomer(idCustomer);
      lease.setDateOfRent(dateOfRent);
      lease.setDateOfReturn(dateOfReturn);
      lease.setSubscriptionType(subscriptionType);
      lease.setIdCarVIN(idCarVIN);

      leases.add(lease);
    }

    return leases;
  }

  @Override
  public Collection<Lease> getAllByIdCar(String id) throws SQLException {

    List<Lease> leases = new ArrayList<>();
    String sql = "SELECT *FROM lease WHERE CaridCarVIN=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setString(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idLease = rs.getInt("idLease");
      int durationMonths = rs.getInt("durationMonths");
      int idCustomer = rs.getInt("CustomeridCustomer");
      Date dateOfRent = rs.getDate("dateOfRent");
      Date dateOfReturn = rs.getDate("dateOfReturn");
      SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));
      String idCarVIN = rs.getString("CaridCarVIN");

      Lease lease = new Lease();
      lease.setIdLease(idLease);
      lease.setDurationMonths(durationMonths);
      lease.setIdCustomer(idCustomer);
      lease.setDateOfRent(dateOfRent);
      lease.setDateOfReturn(dateOfReturn);
      lease.setSubscriptionType(subscriptionType);
      lease.setIdCarVIN(idCarVIN);

      leases.add(lease);
    }

    return leases;
  }

  @Override
  public boolean save(Lease lease) throws SQLException {

    String sql = "INSERT INTO lease (durationMonths,CustomeridCustomer,dateofRent,dateofReturn,subscriptionType, CaridCarVIN)VALUES(?,?,?,?,?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, lease.getDurationMonths());
    psts.setInt(2, lease.getIdCustomer());
    psts.setString(3, String.valueOf(lease.getDateOfRent()));
    psts.setString(4, String.valueOf(lease.getDateOfReturn()));
    psts.setString(5, String.valueOf(lease.getSubscriptionType()));
    psts.setString(6, String.valueOf(lease.getIdCarVIN()));


    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Lease is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(Lease lease) throws SQLException {

    String sql = "UPDATE lease set durationMonths=?, CustomeridCustomer=?, dateofRent=?, dateofReturn=?, subscriptionType=?, CaridCarVIN=? WHERE idLease=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, lease.getDurationMonths());
    psts.setInt(2, lease.getIdCustomer());
    psts.setString(3, String.valueOf(lease.getDateOfRent()));
    psts.setString(4, String.valueOf(lease.getDateOfReturn()));
    psts.setString(5, String.valueOf(lease.getSubscriptionType()));
    psts.setString(6, lease.getIdCarVIN());
    psts.setInt(7, lease.getIdLease());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Lease is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM lease WHERE idLease=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Lease with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
