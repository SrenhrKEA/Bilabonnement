package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlanRef;
import com.srenhrkea.eksamensprojekte22.services.KilometragePlanRefService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class KilometragePlanRefServiceImpl implements KilometragePlanRefService {

  private KilometragePlanRefDAOImpl kilometragePlanRefDAO;

  public KilometragePlanRefServiceImpl(KilometragePlanRefDAOImpl kilometragePlanRefDAO) {
    this.kilometragePlanRefDAO = kilometragePlanRefDAO;
  }

  @Override
  public KilometragePlanRef getKilometragePlanRefById(int id) throws Exception {
    Optional<KilometragePlanRef> kilometragePlanRef = kilometragePlanRefDAO.get(id);
    return kilometragePlanRef.orElseThrow(
        () -> new Exception("A kilometragePlanRef with ID: " + id + ", does not exist."));
  }

  @Override
  public List<KilometragePlanRef> getAllKilometragePlanRefs() throws SQLException {
    return (List<KilometragePlanRef>) kilometragePlanRefDAO.getAll();
  }

  @Override
  public boolean saveKilometragePlanRef(KilometragePlanRef kilometragePlanRef) throws SQLException {
    return kilometragePlanRefDAO.save(kilometragePlanRef);
  }

  @Override
  public boolean updateKilometragePlanRef(KilometragePlanRef kilometragePlanRef) throws SQLException {
    return kilometragePlanRefDAO.update(kilometragePlanRef);
  }

  @Override
  public boolean deleteKilometragePlanRefById(int id) throws SQLException {
    return kilometragePlanRefDAO.delete(id);
  }
}
