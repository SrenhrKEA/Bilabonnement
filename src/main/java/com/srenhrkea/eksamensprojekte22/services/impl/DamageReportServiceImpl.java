package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.DamageReportDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.DamageReport;
import com.srenhrkea.eksamensprojekte22.services.DamageReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DamageReportServiceImpl implements DamageReportService {

  private DamageReportDAOImpl damageReportDAO;

  public DamageReportServiceImpl(DamageReportDAOImpl damageReportDAO) {
    this.damageReportDAO = damageReportDAO;
  }

  @Override
  public DamageReport getDamageReportById(int id) {
    Optional<DamageReport> optional = damageReportDAO.get(id);
    DamageReport damageReport;
    if (optional.isPresent()) {
      damageReport = optional.get();
    } else {
      throw new RuntimeException(" DamageReport with ID: " + id + " does not exist");
    }
    return damageReport;
  }

  @Override
  public List<DamageReport> getAllDamageReports() {
    return (List<DamageReport>) damageReportDAO.getAll();
  }

  @Override
  public void saveDamageReport(DamageReport damageReport) {
    this.damageReportDAO.save(damageReport);
  }

  @Override
  public void updateDamageReport(DamageReport damageReport) {
    int idDamageReport = damageReport.getIdDamageReport();
    Optional<DamageReport> optional = damageReportDAO.get(idDamageReport);
    if (optional.isPresent()) {
      damageReportDAO.update(damageReport);
    } else {
      throw new RuntimeException(" DamageReport with ID: " + idDamageReport + " does not exist");
    }
  }

  @Override
  public void deleteDamageReportById(int id) {
    Optional<DamageReport> optional = damageReportDAO.get(id);
    if (optional.isPresent()) {
      this.damageReportDAO.delete(id);
    } else {
      throw new RuntimeException(" DamageReport with ID: " + id + " does not exist");
    }
  }
}
