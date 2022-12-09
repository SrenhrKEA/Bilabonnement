package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;

import java.sql.SQLException;
import java.util.List;

public interface KilometragePlanService {

  KilometragePlan getKilometragePlanById(int id) throws Exception;

  List<KilometragePlan> getAllKilometragePlans() throws SQLException;

  List<KilometragePlan> getAllKilometragePlansByIdLease(int id) throws SQLException;

  List<KilometragePlan> getAllKilometragePlansByIdKilometragePlan(int id) throws SQLException;

  boolean saveKilometragePlan(KilometragePlan kilometragePlan) throws SQLException;

  boolean updateKilometragePlan(KilometragePlan kilometragePlan) throws SQLException;

  boolean deleteKilometragePlanById(int id) throws SQLException;

}
