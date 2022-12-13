package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.LeaseDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.PickupLocationDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;
import com.srenhrkea.eksamensprojekte22.models.Lease;
import com.srenhrkea.eksamensprojekte22.models.PickupLocation;
import com.srenhrkea.eksamensprojekte22.services.LeaseService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class LeaseServiceImpl implements LeaseService {

  private LeaseDAOImpl leaseDAO;
  private PickupLocationDAOImpl pickupLocationDAO;
  private KilometragePlanDAOImpl kilometragePlanDAO;

  public LeaseServiceImpl(LeaseDAOImpl leaseDAO, PickupLocationDAOImpl pickupLocationDAO, KilometragePlanDAOImpl kilometragePlanDAO) {
    this.leaseDAO = leaseDAO;
    this.pickupLocationDAO = pickupLocationDAO;
    this.kilometragePlanDAO = kilometragePlanDAO;
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
    List<PickupLocation> plList = (List<PickupLocation>) pickupLocationDAO.getAllByIdLease(id);
    for (PickupLocation pickupLocation : plList) {
      pickupLocationDAO.delete(pickupLocation.getIdPickupLocation());
    }
    List<KilometragePlan> kpList = (List<KilometragePlan>) kilometragePlanDAO.getAllByIdLease(id);
    for (KilometragePlan kilometragePlan : kpList) {
      kilometragePlanDAO.delete(kilometragePlan.getIdKilometragePlan());
    }
    return leaseDAO.delete(id);
  }
}
