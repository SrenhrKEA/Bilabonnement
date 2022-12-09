package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.PickupLocation;

import java.sql.SQLException;
import java.util.List;

public interface PickupLocationService {

  PickupLocation getPickupLocationById(int id) throws Exception;

  List<PickupLocation> getAllPickupLocations() throws SQLException;

  List<PickupLocation> getAllPickupLocationsByIdLease(int id) throws SQLException;

  List<PickupLocation> getAllPickupLocationsByIdPickupLocationRef(int id) throws SQLException;

  boolean savePickupLocation(PickupLocation pickupLocation) throws SQLException;

  boolean updatePickupLocation(PickupLocation pickupLocation) throws SQLException;

  boolean deletePickupLocationById(int id) throws SQLException;

}
