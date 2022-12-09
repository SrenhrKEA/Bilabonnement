package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Damage;

import java.sql.SQLException;
import java.util.List;

public interface DamageService {

  Damage getDamageById(int id) throws Exception;

  List<Damage> getAllDamages()throws SQLException;

  List<Damage> getAllDamagesByIdDamageReport(int id)throws SQLException;

  boolean saveDamage(Damage damage)throws SQLException;

  boolean updateDamage(Damage damage)throws SQLException;

  boolean deleteDamageById(int id)throws SQLException;

}
