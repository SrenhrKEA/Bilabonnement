package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.LeaseDAO;
import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;
import com.srenhrkea.eksamensprojekte22.models.Lease;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
@Repository
public class LeaseDAOImpl implements LeaseDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Lease> get(Integer id) {
    Lease lease = null;
    String sql = "SELECT *FROM lease WHERE idLease=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idLease = rs.getInt("idLease");
        int durationMonths = rs.getInt("durationMonths");
        int idCustomer = rs.getInt("CustomeridCustomer");
        Date dateOfRent = rs.getDate("dateOfRent");
        Date dateOfReturn = rs.getDate("dateOfReturn");
        SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));

        lease = new Lease();
        lease.setIdLease(idLease);
        lease.setDurationMonths(durationMonths);
        lease.setIdCustomer(idCustomer);
        lease.setDateOfRent(dateOfRent);
        lease.setDateOfReturn(dateOfReturn);
        lease.setSubscriptionType(subscriptionType);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert lease != null;
    return Optional.of(lease);
  }

  @Override
  public Collection<Lease> getAll() {

    List<Lease> leases = new ArrayList<>();
    String sql = "SELECT *FROM lease";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idLease = rs.getInt("idLease");
        int durationMonths = rs.getInt("durationMonths");
        int idCustomer = rs.getInt("CustomeridCustomer");
        Date dateOfRent = rs.getDate("dateOfRent");
        Date dateOfReturn = rs.getDate("dateOfReturn");
        SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));

        Lease lease = new Lease();
        lease.setIdLease(idLease);
        lease.setDurationMonths(durationMonths);
        lease.setIdCustomer(idCustomer);
        lease.setDateOfRent(dateOfRent);
        lease.setDateOfReturn(dateOfReturn);
        lease.setSubscriptionType(subscriptionType);

        leases.add(lease);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return leases;
  }

  @Override
  public boolean save(Lease lease) {

    String sql = "INSERT INTO lease (durationMonths,CustomeridCustomer,dateofRent,dateofReturn,subscriptionType)VALUES(?,?,?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, lease.getDurationMonths());
      psts.setInt(2, lease.getIdCustomer());
      psts.setString(3, String.valueOf(lease.getDateOfRent()));
      psts.setString(4, String.valueOf(lease.getDateOfReturn()));
      psts.setString(5, String.valueOf(lease.getSubscriptionType()));


      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Lease is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(Lease lease) {

    String sql = "UPDATE lease set durationMonths=?, CustomeridCustomer=?, dateofRent=?, dateofReturn=?, subscriptionType=? WHERE idLease=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, lease.getDurationMonths());
      psts.setInt(2, lease.getIdCustomer());
      psts.setString(3, String.valueOf(lease.getDateOfRent()));
      psts.setString(4, String.valueOf(lease.getDateOfReturn()));
      psts.setString(5, String.valueOf(lease.getSubscriptionType()));

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Lease is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Integer id) {

    String sql = "DELETE FROM lease WHERE idLease=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Lease with ID " + id + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
