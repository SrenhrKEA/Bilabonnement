package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.PickupLocationRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.PickupLocationRef;
import com.srenhrkea.eksamensprojekte22.services.PickupLocationRefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickupLocationRefServiceImpl implements PickupLocationRefService {

  private PickupLocationRefDAOImpl pickupLocationRefDAO;

  public PickupLocationRefServiceImpl(PickupLocationRefDAOImpl pickupLocationRefDAO) {
    this.pickupLocationRefDAO = pickupLocationRefDAO;
  }

  @Override
  public PickupLocationRef getPickupLocationRefById(int id) {
    Optional<PickupLocationRef> optional = pickupLocationRefDAO.get(id);
    PickupLocationRef pickupLocationRef;
    if (optional.isPresent()) {
      pickupLocationRef = optional.get();
    } else {
      throw new RuntimeException(" PickupLocationRef with ID: " + id + " does not exist");
    }
    return pickupLocationRef;
  }

  @Override
  public List<PickupLocationRef> getAllPickupLocationRefs() {
    return (List<PickupLocationRef>) pickupLocationRefDAO.getAll();
  }

  @Override
  public void savePickupLocationRef(PickupLocationRef pickupLocationRef) {
    this.pickupLocationRefDAO.save(pickupLocationRef);
  }

  @Override
  public void updatePickupLocationRef(PickupLocationRef pickupLocationRef) {
    int idPickupLocationRef = pickupLocationRef.getIdPickupLocationRef();
    Optional<PickupLocationRef> optional = pickupLocationRefDAO.get(idPickupLocationRef);
    if (optional.isPresent()) {
      pickupLocationRefDAO.update(pickupLocationRef);
    } else {
      throw new RuntimeException(" PickupLocationRef with ID: " + idPickupLocationRef + " does not exist");
    }
  }

  @Override
  public void deletePickupLocationRefById(int id) {
    Optional<PickupLocationRef> optional = pickupLocationRefDAO.get(id);
    if (optional.isPresent()) {
      this.pickupLocationRefDAO.delete(id);
    } else {
      throw new RuntimeException(" PickupLocationRef with ID: " + id + " does not exist");
    }
  }
}
