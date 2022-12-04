package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Damage;

import java.util.List;

public interface DamageService {

  Damage getDamageById(int id);

  List<Damage> getAllDamages();

  List<Damage> getAllDamagesByIdDamageReport(int id);

  void saveDamage(Damage damage);

  void updateDamage(Damage damage);

  void deleteDamageById(int id);

}
