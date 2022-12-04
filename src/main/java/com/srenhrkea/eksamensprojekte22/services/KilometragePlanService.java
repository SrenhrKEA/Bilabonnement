package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;

import java.util.List;

public interface KilometragePlanService {

  KilometragePlan getKilometragePlanById(int id);

  List<KilometragePlan> getAllKilometragePlans();

  List<KilometragePlan> getAllKilometragePlansByIdLease(int id);

  List<KilometragePlan> getAllKilometragePlansByIdKilometragePlan(int id);

  void saveKilometragePlan(KilometragePlan kilometragePlan);

  void updateKilometragePlan(KilometragePlan kilometragePlan);

  void deleteKilometragePlanById(int id);

}
