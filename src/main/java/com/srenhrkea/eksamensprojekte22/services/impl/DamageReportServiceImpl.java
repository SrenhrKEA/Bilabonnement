package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.DamageDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.DamageReportDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.DamageReport;
import com.srenhrkea.eksamensprojekte22.services.DamageReportService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DamageReportServiceImpl implements DamageReportService {

  private DamageReportDAOImpl damageReportDAO;

  public DamageReportServiceImpl(DamageReportDAOImpl damageReportDAO) {
    this.damageReportDAO = damageReportDAO;
  }

  @Override
  public DamageReport getDamageReportById(int id) throws Exception {
    Optional<DamageReport> damageReport = damageReportDAO.get(id);
    return damageReport.orElseThrow(
        () -> new Exception("A damageReport with ID: " + id + ", does not exist."));
  }

  @Override
  public List<DamageReport> getAllDamageReports() throws SQLException {
    return (List<DamageReport>) damageReportDAO.getAll();
  }

  @Override
  public List<DamageReport> getAllDamageReportsByIdCarVIN(String id) throws SQLException {
    return (List<DamageReport>) damageReportDAO.getAllByIdCarVIN(id);
  }

  @Override
  public boolean saveDamageReport(DamageReport damageReport) throws SQLException {
    return damageReportDAO.save(damageReport);
  }

  @Override
  public boolean updateDamageReport(DamageReport damageReport) throws SQLException {
    return damageReportDAO.update(damageReport);
  }

  @Override
  public boolean deleteDamageReportById(int id) throws SQLException {
    return damageReportDAO.delete(id);
  }
}
