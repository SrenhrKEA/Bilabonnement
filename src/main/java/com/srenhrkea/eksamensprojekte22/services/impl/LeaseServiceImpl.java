package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.LeaseDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.PickupLocationDAOImpl;
import com.srenhrkea.eksamensprojekte22.entities.Lease;
import com.srenhrkea.eksamensprojekte22.services.LeaseService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class LeaseServiceImpl implements LeaseService {

  private LeaseDAOImpl leaseDAO;

  public LeaseServiceImpl(LeaseDAOImpl leaseDAO) {
    this.leaseDAO = leaseDAO;
  }

  @Override
  public Lease getLeaseById(int id) throws Exception {
    Optional<Lease> lease = leaseDAO.get(id);
    return lease.orElseThrow(
        () -> new Exception("A lease with ID: " + id + ", does not exist."));
  }

  @Override
  public List<Lease> getAllLeases() throws SQLException {
    return (List<Lease>) leaseDAO.getAll();
  }

  @Override
  public List<Lease> getAllLeasesByIdCustomer(int id) throws SQLException {
    return (List<Lease>) leaseDAO.getAllByIdCustomer(id);
  }

  @Override
  public boolean saveLease(Lease lease) throws SQLException {
    return leaseDAO.save(lease);
  }

  @Override
  public boolean updateLease(Lease lease) throws SQLException {
    return leaseDAO.update(lease);
  }

  @Override
  public boolean deleteLeaseById(int id) throws SQLException {
    return leaseDAO.delete(id);
  }
}
