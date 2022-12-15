package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.Lease;

import java.sql.SQLException;
import java.util.List;

public interface LeaseService {

  Lease getLeaseById(int id) throws Exception;

  List<Lease> getAllLeases() throws SQLException;

  List<Lease> getAllLeasesByIdCustomer(int id) throws SQLException;

  boolean saveLease(Lease lease) throws SQLException;

  boolean updateLease(Lease lease) throws SQLException;

  boolean deleteLeaseById(int id) throws SQLException;

}
