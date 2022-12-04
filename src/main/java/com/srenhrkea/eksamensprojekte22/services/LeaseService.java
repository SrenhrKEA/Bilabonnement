package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Lease;

import java.util.List;

public interface LeaseService {

  Lease getLeaseById(int id);

  List<Lease> getAllLeases();

  List<Lease> getAllLeasesByIdCustomer(int id);
  void saveLease(Lease lease);

  void updateLease(Lease lease);

  void deleteLeaseById(int id);

}
