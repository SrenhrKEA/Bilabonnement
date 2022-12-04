package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CustomerDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Customer;
import com.srenhrkea.eksamensprojekte22.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerDAOImpl customerDAO;

  public CustomerServiceImpl(CustomerDAOImpl customerDAO) {
    this.customerDAO = customerDAO;
  }

  @Override
  public Customer getCustomerById(int id) {
    Optional<Customer> optional = customerDAO.get(id);
    Customer customer;
    if (optional.isPresent()) {
      customer = optional.get();
    } else {
      throw new RuntimeException(" Customer with ID: " + id + " does not exist");
    }
    return customer;
  }

  @Override
  public List<Customer> getAllCustomers() {
    return (List<Customer>) customerDAO.getAll();
  }

  @Override
  public void saveCustomer(Customer customer) {
    this.customerDAO.save(customer);
  }

  @Override
  public void updateCustomer(Customer customer) {
    int idCustomer = customer.getIdCustomer();
    Optional<Customer> optional = customerDAO.get(idCustomer);
    if (optional.isPresent()) {
      customerDAO.update(customer);
    } else {
      throw new RuntimeException(" Customer with ID: " + idCustomer + " does not exist");
    }
  }

  @Override
  public void deleteCustomerById(int id) {
    Optional<Customer> optional = customerDAO.get(id);
    if (optional.isPresent()) {
      this.customerDAO.delete(id);
    } else {
      throw new RuntimeException(" Customer with ID: " + id + " does not exist");
    }
  }
}
