package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.KilometragePlanRefDAO;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlanRef;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class KilometragePlanRefDAOImpl implements KilometragePlanRefDAO {
  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<KilometragePlanRef> get(Integer id) {
    KilometragePlanRef kilometragePlanRef = null;
    String sql = "SELECT *FROM kilometrageplanref WHERE idKilometragePlanRef=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idKilometragePlanRef = rs.getInt("idKilometragePlanRef");
        double kilometrage = rs.getDouble("kilometrage");
        double pricePerMonth = rs.getDouble("pricePerMonth");

        kilometragePlanRef = new KilometragePlanRef();
        kilometragePlanRef.setIdKilometragePlanRef(idKilometragePlanRef);
        kilometragePlanRef.setKilometrage(kilometrage);
        kilometragePlanRef.setPricePerMonth(pricePerMonth);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert kilometragePlanRef != null;
    return Optional.of(kilometragePlanRef);
  }

  @Override
  public Collection<KilometragePlanRef> getAll() {

    List<KilometragePlanRef> kilometragePlanRefs= new ArrayList<>();
    String sql = "SELECT *FROM kilometrageplanref";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idKilometragePlanRef = rs.getInt("idKilometragePlanRef");
        double kilometrage = rs.getDouble("kilometrage");
        double pricePerMonth = rs.getDouble("pricePerMonth");

        KilometragePlanRef kilometragePlanRef = new KilometragePlanRef();
        kilometragePlanRef.setIdKilometragePlanRef(idKilometragePlanRef);
        kilometragePlanRef.setKilometrage(kilometrage);
        kilometragePlanRef.setPricePerMonth(pricePerMonth);

        kilometragePlanRefs.add(kilometragePlanRef);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return kilometragePlanRefs;
  }

  @Override
  public boolean save(KilometragePlanRef kilometragePlanRef) {
    String sql = "INSERT INTO kilometrageplanref (kilometrage,pricePerMonth)VALUES(?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setDouble(1, kilometragePlanRef.getKilometrage());
      psts.setDouble(2, kilometragePlanRef.getPricePerMonth());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Kilometrage Plan Reference is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(KilometragePlanRef kilometragePlanRef) {
    String sql = "UPDATE kilometrageplanref set kilometrage=?, pricePerMonth=? WHERE idKilometragePlanRef=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setDouble(1, kilometragePlanRef.getKilometrage());
      psts.setDouble(2, kilometragePlanRef.getPricePerMonth());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Kilometrage Plan Reference is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(KilometragePlanRef kilometragePlanRef) {

    String sql = "DELETE FROM kilometrageplanref WHERE idKilometragePlanRef=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, kilometragePlanRef.getIdKilometragePlanRef());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Kilometrage Plan Reference with ID " + kilometragePlanRef.getIdKilometragePlanRef() + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
