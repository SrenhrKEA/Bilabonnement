package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.DamageReport;

import java.sql.SQLException;
import java.util.List;

public interface DamageReportService {

  DamageReport getDamageReportById(int id) throws Exception;

  List<DamageReport> getAllDamageReports() throws SQLException;

  List<DamageReport> getAllDamageReportsByIdCarVIN(String id) throws SQLException;

  boolean saveDamageReport(DamageReport damageReport) throws SQLException;

  boolean updateDamageReport(DamageReport damageReport) throws SQLException;

  boolean deleteDamageReportById(int id) throws SQLException;

}
