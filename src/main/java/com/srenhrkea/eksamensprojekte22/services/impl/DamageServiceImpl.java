package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.DamageDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Damage;
import com.srenhrkea.eksamensprojekte22.services.DamageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DamageServiceImpl implements DamageService {

  private DamageDAOImpl damageDAO;

  public DamageServiceImpl(DamageDAOImpl damageDAO) {
    this.damageDAO = damageDAO;
  }

  @Override
  public Damage getDamageById(int id) {
    Optional<Damage> optional = damageDAO.get(id);
    Damage damage;
    if (optional.isPresent()) {
      damage = optional.get();
    } else {
      throw new RuntimeException(" Damage with ID: " + id + " does not exist");
    }
    return damage;
  }

  @Override
  public List<Damage> getAllDamages() {
    return (List<Damage>) damageDAO.getAll();
  }

  @Override
  public void saveDamage(Damage damage) {
    this.damageDAO.save(damage);
  }

  @Override
  public void updateDamage(Damage damage) {
    int idDamage = damage.getIdDamage();
    Optional<Damage> optional = damageDAO.get(idDamage);
    if (optional.isPresent()) {
      damageDAO.update(damage);
    } else {
      throw new RuntimeException(" Damage with ID: " + idDamage + " does not exist");
    }
  }

  @Override
  public void deleteDamageById(int id) {
    Optional<Damage> optional = damageDAO.get(id);
    if (optional.isPresent()) {
      this.damageDAO.delete(id);
    } else {
      throw new RuntimeException(" Damage with ID: " + id + " does not exist");
    }
  }
}
