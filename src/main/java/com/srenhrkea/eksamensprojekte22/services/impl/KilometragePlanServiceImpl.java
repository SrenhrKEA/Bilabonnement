package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;
import com.srenhrkea.eksamensprojekte22.services.KilometragePlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KilometragePlanServiceImpl implements KilometragePlanService {

  private KilometragePlanDAOImpl kilometragePlanDAO;

  public KilometragePlanServiceImpl(KilometragePlanDAOImpl kilometragePlanDAO) {
    this.kilometragePlanDAO = kilometragePlanDAO;
  }

  @Override
  public KilometragePlan getKilometragePlanById(int id) {
    Optional<KilometragePlan> optional = kilometragePlanDAO.get(id);
    KilometragePlan kilometragePlan;
    if (optional.isPresent()) {
      kilometragePlan = optional.get();
    } else {
      throw new RuntimeException(" KilometragePlan with ID: " + id + " does not exist");
    }
    return kilometragePlan;
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlans() {
    return (List<KilometragePlan>) kilometragePlanDAO.getAll();
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlansByIdLease(int id) {
    return (List<KilometragePlan>) kilometragePlanDAO.getAllByIdLease(id);
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlansByIdKilometragePlan(int id) {
    return (List<KilometragePlan>) kilometragePlanDAO.getAllByIdKilometragePlanRef(id);
  }

  @Override
  public void saveKilometragePlan(KilometragePlan kilometragePlan) {
    this.kilometragePlanDAO.save(kilometragePlan);
  }

  @Override
  public void updateKilometragePlan(KilometragePlan kilometragePlan) {
    int idKilometragePlan = kilometragePlan.getIdKilometragePlan();
    Optional<KilometragePlan> optional = kilometragePlanDAO.get(idKilometragePlan);
    if (optional.isPresent()) {
      kilometragePlanDAO.update(kilometragePlan);
    } else {
      throw new RuntimeException(" KilometragePlan with ID: " + idKilometragePlan + " does not exist");
    }
  }

  @Override
  public void deleteKilometragePlanById(int id) {
    Optional<KilometragePlan> optional = kilometragePlanDAO.get(id);
    if (optional.isPresent()) {
      this.kilometragePlanDAO.delete(id);
    } else {
      throw new RuntimeException(" KilometragePlan with ID: " + id + " does not exist");
    }
  }
}
