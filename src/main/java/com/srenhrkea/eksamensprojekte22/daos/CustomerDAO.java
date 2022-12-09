package com.srenhrkea.eksamensprojekte22.daos;

import com.srenhrkea.eksamensprojekte22.daos.generic.GenericDAO;
import com.srenhrkea.eksamensprojekte22.models.Customer;

import java.sql.SQLException;
import java.util.Optional;

public interface CustomerDAO extends GenericDAO<Customer, Integer> {
}
