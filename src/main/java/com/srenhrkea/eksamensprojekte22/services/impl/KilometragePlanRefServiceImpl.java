package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlanRef;
import com.srenhrkea.eksamensprojekte22.services.KilometragePlanRefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KilometragePlanRefServiceImpl implements KilometragePlanRefService {

  private KilometragePlanRefDAOImpl kilometragePlanRefDAO;

  public KilometragePlanRefServiceImpl(KilometragePlanRefDAOImpl kilometragePlanRefDAO) {
    this.kilometragePlanRefDAO = kilometragePlanRefDAO;
  }

  @Override
  public KilometragePlanRef getKilometragePlanRefById(int id) {
    Optional<KilometragePlanRef> optional = kilometragePlanRefDAO.get(id);
    KilometragePlanRef kilometragePlanRef;
    if (optional.isPresent()) {
      kilometragePlanRef = optional.get();
    } else {
      throw new RuntimeException(" KilometragePlanRef with ID: " + id + " does not exist");
    }
    return kilometragePlanRef;
  }

  @Override
  public List<KilometragePlanRef> getAllKilometragePlanRefs() {
    return (List<KilometragePlanRef>) kilometragePlanRefDAO.getAll();
  }

  @Override
  public void saveKilometragePlanRef(KilometragePlanRef kilometragePlanRef) {
    this.kilometragePlanRefDAO.save(kilometragePlanRef);
  }

  @Override
  public void updateKilometragePlanRef(KilometragePlanRef kilometragePlanRef) {
    int idKilometragePlanRef = kilometragePlanRef.getIdKilometragePlanRef();
    Optional<KilometragePlanRef> optional = kilometragePlanRefDAO.get(idKilometragePlanRef);
    if (optional.isPresent()) {
      kilometragePlanRefDAO.update(kilometragePlanRef);
    } else {
      throw new RuntimeException(" KilometragePlanRef with ID: " + idKilometragePlanRef + " does not exist");
    }
  }

  @Override
  public void deleteKilometragePlanRefById(int id) {
    Optional<KilometragePlanRef> optional = kilometragePlanRefDAO.get(id);
    if (optional.isPresent()) {
      this.kilometragePlanRefDAO.delete(id);
    } else {
      throw new RuntimeException(" KilometragePlanRef with ID: " + id + " does not exist");
    }
  }
}
