package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.LeaseDAO;
import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;
import com.srenhrkea.eksamensprojekte22.models.Lease;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
        SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));
        Date dateRented = rs.getDate("dateRented");
        double price = rs.getDouble("price");
        boolean billed = rs.getBoolean("billed");
        boolean billPaid = rs.getBoolean("billPaid");

        lease = new Lease();
        lease.setId(idLease);
        lease.setDurationMonths(durationMonths);
        lease.setSubscriptionType(subscriptionType);
        lease.setDateRented(dateRented);
        lease.setPrice(price);
        lease.setBilled(billed);
        lease.setBillPaid(billPaid);
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
        SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscriptionType"));
        Date dateRented = rs.getDate("dateRented");
        double price = rs.getDouble("price");
        boolean billed = rs.getBoolean("billed");
        boolean billPaid = rs.getBoolean("billPaid");

        Lease lease = new Lease();
        lease.setId(idLease);
        lease.setDurationMonths(durationMonths);
        lease.setSubscriptionType(subscriptionType);
        lease.setDateRented(dateRented);
        lease.setPrice(price);
        lease.setBilled(billed);
        lease.setBillPaid(billPaid);

        leases.add(lease);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return leases;
  }

  @Override
  public boolean save(Lease lease) {

    String sql = "INSERT INTO lease (durationMonths,subscriptionType,dateRented,price,billed,billPaid)VALUES(?,?,?,?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, lease.getDurationMonths());
      psts.setString(2, String.valueOf(lease.getSubscriptionType()));
      psts.setString(3, String.valueOf(lease.getDateRented()));
      psts.setDouble(4, lease.getPrice());
      psts.setBoolean(5, lease.isBilled());
      psts.setBoolean(6, lease.isBillPaid());


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

    String sql = "UPDATE lease set durationMonths=?, subscriptionType=?, dateRented=?, price=?, billed=?, billPaid=? WHERE idLease=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, lease.getDurationMonths());
      psts.setString(2, String.valueOf(lease.getSubscriptionType()));
      psts.setString(3, String.valueOf(lease.getDateRented()));
      psts.setDouble(4, lease.getPrice());
      psts.setBoolean(5, lease.isBilled());
      psts.setBoolean(6, lease.isBillPaid());

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
  public boolean delete(Lease lease) {

    String sql = "DELETE FROM lease WHERE idLease=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, lease.getId());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Lease with ID " + lease.getId() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
