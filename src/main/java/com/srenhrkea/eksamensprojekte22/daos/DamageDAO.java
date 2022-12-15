package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.entities.Damage;

import java.sql.SQLException;
import java.util.Collection;

public interface DamageDAO extends GenericDAO<Damage, Integer> {
  Collection<Damage> getAllByIdDamageReport(Integer id) throws SQLException;

}
