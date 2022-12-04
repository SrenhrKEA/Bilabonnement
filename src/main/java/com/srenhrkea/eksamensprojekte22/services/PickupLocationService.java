package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.PickupLocation;

import java.util.List;

public interface PickupLocationService {

  PickupLocation getPickupLocationById(int id);

  List<PickupLocation> getAllPickupLocations();

  void savePickupLocation(PickupLocation pickupLocation);

  void updatePickupLocation(PickupLocation pickupLocation);

  void deletePickupLocationById(int id);

}
