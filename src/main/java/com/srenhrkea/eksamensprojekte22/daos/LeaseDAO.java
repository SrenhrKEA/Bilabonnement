package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.models.Lease;

import java.util.Collection;

public interface LeaseDAO extends GenericDAO<Lease, Integer> {

  Collection<Lease> getAllByIdCustomer(Integer id);
}
