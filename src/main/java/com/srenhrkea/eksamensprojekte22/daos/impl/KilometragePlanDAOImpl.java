package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.KilometragePlanDAO;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class KilometragePlanDAOImpl implements KilometragePlanDAO {
  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<KilometragePlan> get(Integer id) {
    KilometragePlan kilometragePlan = null;
    String sql = "SELECT *FROM kilometrageplan WHERE idKilometragePlan=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

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

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert kilometragePlan != null;
    return Optional.of(kilometragePlan);
  }

  @Override
  public Collection<KilometragePlan> getAll() {

    List<KilometragePlan> kilometragePlans = new ArrayList<>();
    String sql = "SELECT *FROM kilometrageplan";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

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

    } catch (Exception e) {
      e.printStackTrace();
    }
    return kilometragePlans;
  }

  @Override
  public boolean save(KilometragePlan kilometragePlan) {

    String sql = "INSERT INTO kilometrageplan(LeaseidLease,KilometragePlanRefidKilometragePlanRef)VALUES(?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, kilometragePlan.getIdLease());
      psts.setInt(2, kilometragePlan.getIdKilometragePlanRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Kilometrage Plan is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(KilometragePlan kilometragePlan) {

    String sql = "UPDATE kilometrageplan set LeaseidLease=?, KilometragePlanRefidKilometragePlanRef=? WHERE idKilometragePlan=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, kilometragePlan.getIdLease());
      psts.setInt(2, kilometragePlan.getIdKilometragePlanRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Kilometrage Plan is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(KilometragePlan kilometragePlan) {

    String sql = "DELETE FROM kilometrageplan WHERE idKilometragePlan=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, kilometragePlan.getIdKilometragePlan());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Kilometrage Plan with ID " + kilometragePlan.getIdKilometragePlan() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}