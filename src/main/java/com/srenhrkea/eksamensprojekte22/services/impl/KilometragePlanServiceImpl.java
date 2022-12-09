package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;
import com.srenhrkea.eksamensprojekte22.services.KilometragePlanService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class KilometragePlanServiceImpl implements KilometragePlanService {

  private KilometragePlanDAOImpl kilometragePlanDAO;

  public KilometragePlanServiceImpl(KilometragePlanDAOImpl kilometragePlanDAO) {
    this.kilometragePlanDAO = kilometragePlanDAO;
  }

  @Override
  public KilometragePlan getKilometragePlanById(int id) throws Exception {
    Optional<KilometragePlan> kilometragePlan = kilometragePlanDAO.get(id);
    return kilometragePlan.orElseThrow(
        () -> new Exception("A kilometragePlan with ID: " + id + ", does not exist."));
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlans() throws SQLException {
    return (List<KilometragePlan>) kilometragePlanDAO.getAll();
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlansByIdLease(int id) throws SQLException {
    return (List<KilometragePlan>) kilometragePlanDAO.getAllByIdLease(id);
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlansByIdKilometragePlan(int id) throws SQLException {
    return (List<KilometragePlan>) kilometragePlanDAO.getAllByIdKilometragePlanRef(id);
  }

  @Override
  public boolean saveKilometragePlan(KilometragePlan kilometragePlan) throws SQLException {
    return kilometragePlanDAO.save(kilometragePlan);
  }

  @Override
  public boolean updateKilometragePlan(KilometragePlan kilometragePlan) throws SQLException {
    return kilometragePlanDAO.update(kilometragePlan);
  }

  @Override
  public boolean deleteKilometragePlanById(int id) throws SQLException {
    return kilometragePlanDAO.delete(id);
  }
}
