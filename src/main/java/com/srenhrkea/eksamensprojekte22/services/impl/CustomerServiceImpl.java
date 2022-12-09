package com.srenhrkea.eksamensprojekte22.services.impl;

import com.srenhrkea.eksamensprojekte22.daos.impl.CustomerDAOImpl;
import com.srenhrkea.eksamensprojekte22.models.Customer;
import com.srenhrkea.eksamensprojekte22.services.CustomerService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerDAOImpl customerDAO;

  public CustomerServiceImpl(CustomerDAOImpl customerDAO) {
    this.customerDAO = customerDAO;
  }

  @Override
  public Customer getCustomerById(int id) throws Exception {
    Optional<Customer> customer = customerDAO.get(id);
    return customer.orElseThrow(
        () -> new Exception("A customer with ID: " + id + ", does not exist."));
  }

  @Override
  public List<Customer> getAllCustomers() throws SQLException {
    return (List<Customer>) customerDAO.getAll();
  }

  @Override
  public boolean saveCustomer(Customer customer) throws SQLException {
    return customerDAO.save(customer);
  }

  @Override
  public boolean updateCustomer(Customer customer) throws SQLException {
    return customerDAO.update(customer);
  }

  @Override
  public boolean deleteCustomerById(int id) throws SQLException {
    return customerDAO.delete(id);
  }
}
