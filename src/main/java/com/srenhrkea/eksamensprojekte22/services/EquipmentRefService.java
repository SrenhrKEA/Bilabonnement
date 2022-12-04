package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.EquipmentRef;

import java.util.List;

public interface EquipmentRefService {

  EquipmentRef getEquipmentRefById(int id);

  List<EquipmentRef> getAllEquipmentRefs();

  void saveEquipmentRef(EquipmentRef equipmentRef);

  void updateEquipmentRef(EquipmentRef equipmentRef);

  void deleteEquipmentRefById(int id);

}
