package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.DamageDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Damage;
import com.srenhrkea.eksamensprojekte22.services.DamageService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DamageServiceImpl implements DamageService {

  private DamageDAOImpl damageDAO;

  public DamageServiceImpl(DamageDAOImpl damageDAO) {
    this.damageDAO = damageDAO;
  }

  @Override
  public Damage getDamageById(int id) throws Exception {
    Optional<Damage> damage = damageDAO.get(id);
    return damage.orElseThrow(
        () -> new Exception("A damage with ID: " + id + ", does not exist."));
  }

  @Override
  public List<Damage> getAllDamages() throws SQLException {
    return (List<Damage>) damageDAO.getAll();
  }

  @Override
  public List<Damage> getAllDamagesByIdDamageReport(int id) throws SQLException {
    return (List<Damage>) damageDAO.getAllByIdDamageReport(id);
  }

  @Override
  public boolean saveDamage(Damage damage) throws SQLException {
    return damageDAO.save(damage);
  }

  @Override
  public boolean updateDamage(Damage damage) throws SQLException {
    return damageDAO.update(damage);
  }

  @Override
  public boolean deleteDamageById(int id) throws SQLException {
    return damageDAO.delete(id);
  }
}
