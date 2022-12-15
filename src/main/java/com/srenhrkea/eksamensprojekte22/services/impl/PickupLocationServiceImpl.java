package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.PickupLocationDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.PickupLocation;
import com.srenhrkea.eksamensprojekte22.services.PickupLocationService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PickupLocationServiceImpl implements PickupLocationService {

  private PickupLocationDAOImpl pickupLocationDAO;

  public PickupLocationServiceImpl(PickupLocationDAOImpl pickupLocationDAO) {
    this.pickupLocationDAO = pickupLocationDAO;
  }

  @Override
  public PickupLocation getPickupLocationById(int id) throws Exception {
    Optional<PickupLocation> pickupLocation = pickupLocationDAO.get(id);
    return pickupLocation.orElseThrow(
        () -> new Exception("A pickupLocation with ID: " + id + ", does not exist."));
  }

  @Override
  public List<PickupLocation> getAllPickupLocations() throws SQLException {
    return (List<PickupLocation>) pickupLocationDAO.getAll();
  }

  @Override
  public List<PickupLocation> getAllPickupLocationsByIdLease(int id) throws SQLException {
    return (List<PickupLocation>) pickupLocationDAO.getAllByIdLease(id);
  }

  @Override
  public List<PickupLocation> getAllPickupLocationsByIdPickupLocationRef(int id) throws SQLException {
    return (List<PickupLocation>) pickupLocationDAO.getAllByIdPickupLocationRef(id);
  }

  @Override
  public boolean savePickupLocation(PickupLocation pickupLocation) throws SQLException {
    return pickupLocationDAO.save(pickupLocation);
  }

  @Override
  public boolean updatePickupLocation(PickupLocation pickupLocation) throws SQLException {
    return pickupLocationDAO.update(pickupLocation);
  }

  @Override
  public boolean deletePickupLocationById(int id) throws SQLException {
    return pickupLocationDAO.delete(id);
  }
}
