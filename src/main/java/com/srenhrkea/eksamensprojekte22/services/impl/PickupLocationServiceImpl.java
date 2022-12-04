package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.PickupLocationDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.PickupLocation;
import com.srenhrkea.eksamensprojekte22.services.PickupLocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickupLocationServiceImpl implements PickupLocationService {

  private PickupLocationDAOImpl pickupLocationDAO;

  public PickupLocationServiceImpl(PickupLocationDAOImpl pickupLocationDAO) {
    this.pickupLocationDAO = pickupLocationDAO;
  }

  @Override
  public PickupLocation getPickupLocationById(int id) {
    Optional<PickupLocation> optional = pickupLocationDAO.get(id);
    PickupLocation pickupLocation;
    if (optional.isPresent()) {
      pickupLocation = optional.get();
    } else {
      throw new RuntimeException(" PickupLocation with ID: " + id + " does not exist");
    }
    return pickupLocation;
  }

  @Override
  public List<PickupLocation> getAllPickupLocations() {
    return (List<PickupLocation>) pickupLocationDAO.getAll();
  }

  @Override
  public List<PickupLocation> getAllPickupLocationsByIdLease(int id) {
    return (List<PickupLocation>) pickupLocationDAO.getAllByIdLease(id);
  }

  @Override
  public List<PickupLocation> getAllPickupLocationsByIdPickupLocationRef(int id) {
    return (List<PickupLocation>) pickupLocationDAO.getAllByIdPickupLocationRef(id);
  }

  @Override
  public void savePickupLocation(PickupLocation pickupLocation) {
    this.pickupLocationDAO.save(pickupLocation);
  }

  @Override
  public void updatePickupLocation(PickupLocation pickupLocation) {
    int idPickupLocation = pickupLocation.getIdPickupLocation();
    Optional<PickupLocation> optional = pickupLocationDAO.get(idPickupLocation);
    if (optional.isPresent()) {
      pickupLocationDAO.update(pickupLocation);
    } else {
      throw new RuntimeException(" PickupLocation with ID: " + idPickupLocation + " does not exist");
    }
  }

  @Override
  public void deletePickupLocationById(int id) {
    Optional<PickupLocation> optional = pickupLocationDAO.get(id);
    if (optional.isPresent()) {
      this.pickupLocationDAO.delete(id);
    } else {
      throw new RuntimeException(" PickupLocation with ID: " + id + " does not exist");
    }
  }
}
