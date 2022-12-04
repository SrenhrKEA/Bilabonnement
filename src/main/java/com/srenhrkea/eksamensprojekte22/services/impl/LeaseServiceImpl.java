package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.LeaseDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Lease;
import com.srenhrkea.eksamensprojekte22.services.LeaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseServiceImpl implements LeaseService {

  private LeaseDAOImpl leaseDAO;

  public LeaseServiceImpl(LeaseDAOImpl leaseDAO) {
    this.leaseDAO = leaseDAO;
  }

  @Override
  public Lease getLeaseById(int id) {
    Optional<Lease> optional = leaseDAO.get(id);
    Lease lease;
    if (optional.isPresent()) {
      lease = optional.get();
    } else {
      throw new RuntimeException(" Lease with ID: " + id + " does not exist");
    }
    return lease;
  }

  @Override
  public List<Lease> getAllLeases() {
    return (List<Lease>) leaseDAO.getAll();
  }

  @Override
  public List<Lease> getAllLeasesByIdCustomer(int id) {
    return (List<Lease>) leaseDAO.getAllByIdCustomer(id);
  }

  @Override
  public void saveLease(Lease lease) {
    this.leaseDAO.save(lease);
  }

  @Override
  public void updateLease(Lease lease) {
    int idLease = lease.getIdLease();
    Optional<Lease> optional = leaseDAO.get(idLease);
    if (optional.isPresent()) {
      leaseDAO.update(lease);
    } else {
      throw new RuntimeException(" Lease with ID: " + idLease + " does not exist");
    }
  }

  @Override
  public void deleteLeaseById(int id) {
    Optional<Lease> optional = leaseDAO.get(id);
    if (optional.isPresent()) {
      this.leaseDAO.delete(id);
    } else {
      throw new RuntimeException(" Lease with ID: " + id + " does not exist");
    }
  }
}
