package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CarDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.KilometragePlanRefDAOImpl;
import com.srenhrkea.eksamensprojekte22.daos.impl.LeaseDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Car;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlan;
import com.srenhrkea.eksamensprojekte22.models.KilometragePlanRef;
import com.srenhrkea.eksamensprojekte22.models.Lease;
import com.srenhrkea.eksamensprojekte22.services.KilometragePlanService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KilometragePlanServiceImpl implements KilometragePlanService {

  private KilometragePlanDAOImpl kilometragePlanDAO;
  private KilometragePlanRefDAOImpl kilometragePlanRefDAO;
  private LeaseDAOImpl leaseDAO;
  private CarDAOImpl carDAO;

  public KilometragePlanServiceImpl(KilometragePlanDAOImpl kilometragePlanDAO, KilometragePlanRefDAOImpl kilometragePlanRefDAO, LeaseDAOImpl leaseDAO, CarDAOImpl carDAO) {
    this.kilometragePlanDAO = kilometragePlanDAO;
    this.kilometragePlanRefDAO = kilometragePlanRefDAO;
    this.leaseDAO = leaseDAO;
    this.carDAO = carDAO;
  }

  @Override
  public KilometragePlan getKilometragePlanById(int id) throws Exception {
    Optional<KilometragePlan> kilometragePlan = kilometragePlanDAO.get(id);
    return kilometragePlan.orElseThrow(
        () -> new Exception("A kilometragePlan with ID: " + id + ", does not exist."));
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlans() throws SQLException {
    return (List<KilometragePlan>) kilometragePlanDAO.getAll();
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlansByIdLease(int id) throws SQLException {
    return (List<KilometragePlan>) kilometragePlanDAO.getAllByIdLease(id);
  }

  @Override
  public List<KilometragePlan> getAllKilometragePlansByIdKilometragePlan(int id) throws SQLException {
    return (List<KilometragePlan>) kilometragePlanDAO.getAllByIdKilometragePlanRef(id);
  }

  @Override
  public boolean saveKilometragePlan(KilometragePlan kilometragePlan) throws SQLException {
    return kilometragePlanDAO.save(kilometragePlan);
  }

  @Override
  public boolean updateKilometragePlan(KilometragePlan kilometragePlan) throws SQLException {
    return kilometragePlanDAO.update(kilometragePlan);
  }

  @Override
  public boolean deleteKilometragePlanById(int id) throws SQLException {
    return kilometragePlanDAO.delete(id);
  }

  @Override
  public double GetIncomePerMonth() throws SQLException {
    double income = 0;
    List<Car> cars = (List<Car>) carDAO.getAllByIsNotAvailable();
    List<Lease> leases = new ArrayList<>();
    List<KilometragePlan> kilometragePlans = new ArrayList<>();
    for (Car car : cars) {
      String idCarVin = car.getIdCarVIN();
      System.out.println(car);
      leases.addAll(leaseDAO.getAllByIdCar(idCarVin));
      System.out.println(leases);
      for (Lease lease : leases) {
        int idLease = lease.getIdLease();
        kilometragePlans.addAll( kilometragePlanDAO.getAllByIdLease(idLease));
        for (KilometragePlan kilometragePlan : kilometragePlans) {
          int idKilometragePlanRef = kilometragePlan.getIdKilometragePlanRef();
          Optional<KilometragePlanRef> kilometragePlanRef = kilometragePlanRefDAO.get(idKilometragePlanRef);
          if (kilometragePlanRef.isPresent()) {
            income = income + kilometragePlanRef.get().getPricePerMonth();
          }
        }
      }
    }
    return income;
  }


}
