package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.DamageReport;

import java.util.List;

public interface DamageReportService {

  DamageReport getDamageReportById(int id);

  List<DamageReport> getAllDamageReports();

  void saveDamageReport(DamageReport damageReport);

  void updateDamageReport(DamageReport damageReport);

  void deleteDamageReportById(int id);

}
