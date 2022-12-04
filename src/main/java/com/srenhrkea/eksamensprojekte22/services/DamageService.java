package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Damage;

import java.util.List;

public interface DamageService {

  Damage getDamageById(int id);

  List<Damage> getAllDamages();

  void saveDamage(Damage damage);

  void updateDamage(Damage damage);

  void deleteDamageById(int id);

}
