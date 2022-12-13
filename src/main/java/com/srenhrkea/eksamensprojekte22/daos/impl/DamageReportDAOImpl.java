package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.DamageReportDAO;
import com.srenhrkea.eksamensprojekte22.models.DamageReport;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class DamageReportDAOImpl implements DamageReportDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<DamageReport> get(Integer id) throws SQLException {
    DamageReport damageReport = null;
    String sql = "SELECT *FROM damagereport WHERE idDamageReport=?";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    ResultSet rs = psts.executeQuery();
    if (rs.next()) {
      int idDamageReport = rs.getInt("idDamageReport");
      String idCarVIN = rs.getString("CaridCarVIN");
      String dateOfReport = rs.getString("dateOfReport");

      damageReport = new DamageReport();
      damageReport.setIdDamageReport(idDamageReport);
      damageReport.setIdCarVIN(idCarVIN);
      damageReport.setDateOfReport(LocalDate.parse(dateOfReport));

    }


    assert damageReport != null;
    return Optional.of(damageReport);
  }

  @Override
  public Collection<DamageReport> getAll() throws SQLException {

    List<DamageReport> damageReports = new ArrayList<>();
    String sql = "SELECT *FROM damagereport";
    PreparedStatement psts = conn.prepareStatement(sql);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idDamageReport = rs.getInt("idDamageReport");
      String idCarVIN = rs.getString("CaridCarVIN");
      String dateOfReport = rs.getString("dateOfReport");

      DamageReport damageReport = new DamageReport();
      damageReport.setIdDamageReport(idDamageReport);
      damageReport.setIdCarVIN(idCarVIN);
      damageReport.setDateOfReport(LocalDate.parse(dateOfReport));

      damageReports.add(damageReport);
    }

    return damageReports;
  }

  @Override
  public Collection<DamageReport> getAllByIdCarVIN(String id) throws SQLException {

    List<DamageReport> damageReports = new ArrayList<>();
    String sql = "SELECT *FROM damagereport WHERE CaridCarVIN=?";
    PreparedStatement psts = conn.prepareStatement(sql);
    psts.setString(1, id);

    ResultSet rs = psts.executeQuery();
    while (rs.next()) {
      int idDamageReport = rs.getInt("idDamageReport");
      String idCarVIN = rs.getString("CaridCarVIN");
      String dateOfReport = rs.getString("dateOfReport");

      DamageReport damageReport = new DamageReport();
      damageReport.setIdDamageReport(idDamageReport);
      damageReport.setIdCarVIN(idCarVIN);
      damageReport.setDateOfReport(LocalDate.parse(dateOfReport));

      damageReports.add(damageReport);
    }

    return damageReports;
  }

  @Override
  public boolean save(DamageReport damageReport) throws SQLException {

    String sql = "INSERT INTO damagereport (CaridCarVIN,dateOfReport)VALUES(?,?)";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, damageReport.getIdCarVIN());
    psts.setString(2, String.valueOf(damageReport.getDateOfReport()));


    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Damage Report is saved.");
      return true;
    }

    return false;
  }

  @Override
  public boolean update(DamageReport damageReport) throws SQLException {

    String sql = "UPDATE damagereport set CaridCarVIN=?, dateOfReport=? WHERE idDamageReport=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setString(1, damageReport.getIdCarVIN());
    psts.setString(2, String.valueOf(damageReport.getDateOfReport()));
    psts.setInt(3, damageReport.getIdDamageReport());

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Damage Report is updated.");
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Integer id) throws SQLException {

    String sql = "DELETE FROM damagereport WHERE idDamageReport=?;";
    PreparedStatement psts = conn.prepareStatement(sql);

    psts.setInt(1, id);

    int executeUpdate = psts.executeUpdate();

    if (executeUpdate == 1) {
      System.out.println("Damage Report with ID " + id + " is deleted.::");
      return true;
    }

    return false;
  }
}
