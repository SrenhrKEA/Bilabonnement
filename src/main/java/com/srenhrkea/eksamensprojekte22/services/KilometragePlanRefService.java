package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.KilometragePlanRef;

import java.util.List;

public interface KilometragePlanRefService {

  KilometragePlanRef getKilometragePlanRefById(int id);

  List<KilometragePlanRef> getAllKilometragePlanRefs();

  void saveKilometragePlanRef(KilometragePlanRef kilometragePlanRef);

  void updateKilometragePlanRef(KilometragePlanRef kilometragePlanRef);

  void deleteKilometragePlanRefById(int id);

}
