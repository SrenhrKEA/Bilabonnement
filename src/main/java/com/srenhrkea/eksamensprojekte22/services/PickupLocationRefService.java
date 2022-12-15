package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.PickupLocationRef;

import java.sql.SQLException;
import java.util.List;

public interface PickupLocationRefService {

  PickupLocationRef getPickupLocationRefById(int id) throws Exception;

  List<PickupLocationRef> getAllPickupLocationRefs() throws SQLException;

  boolean savePickupLocationRef(PickupLocationRef pickupLocationRef) throws SQLException;

  boolean updatePickupLocationRef(PickupLocationRef pickupLocationRef) throws SQLException;

  boolean deletePickupLocationRefById(int id) throws SQLException;

}
