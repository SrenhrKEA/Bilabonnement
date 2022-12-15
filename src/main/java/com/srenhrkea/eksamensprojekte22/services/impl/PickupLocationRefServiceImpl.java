package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.PickupLocationRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.PickupLocationRef;
import com.srenhrkea.eksamensprojekte22.services.PickupLocationRefService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PickupLocationRefServiceImpl implements PickupLocationRefService {

  private PickupLocationRefDAOImpl pickupLocationRefDAO;

  public PickupLocationRefServiceImpl(PickupLocationRefDAOImpl pickupLocationRefDAO) {
    this.pickupLocationRefDAO = pickupLocationRefDAO;
  }

  @Override
  public PickupLocationRef getPickupLocationRefById(int id) throws Exception {
    Optional<PickupLocationRef> pickupLocationRef = pickupLocationRefDAO.get(id);
    return pickupLocationRef.orElseThrow(
        () -> new Exception("A pickupLocationRef with ID: " + id + ", does not exist."));
  }

  @Override
  public List<PickupLocationRef> getAllPickupLocationRefs() throws SQLException {
    return (List<PickupLocationRef>) pickupLocationRefDAO.getAll();
  }

  @Override
  public boolean savePickupLocationRef(PickupLocationRef pickupLocationRef) throws SQLException {
    return pickupLocationRefDAO.save(pickupLocationRef);
  }

  @Override
  public boolean updatePickupLocationRef(PickupLocationRef pickupLocationRef) throws SQLException {
    return pickupLocationRefDAO.update(pickupLocationRef);
  }

  @Override
  public boolean deletePickupLocationRefById(int id) throws SQLException {
    return pickupLocationRefDAO.delete(id);
  }
}
