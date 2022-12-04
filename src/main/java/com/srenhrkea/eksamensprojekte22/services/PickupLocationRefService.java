package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.PickupLocationRef;

import java.util.List;

public interface PickupLocationRefService {

  PickupLocationRef getPickupLocationRefById(int id);

  List<PickupLocationRef> getAllPickupLocationRefs();

  void savePickupLocationRef(PickupLocationRef pickupLocationRef);

  void updatePickupLocationRef(PickupLocationRef pickupLocationRef);

  void deletePickupLocationRefById(int id);

}
