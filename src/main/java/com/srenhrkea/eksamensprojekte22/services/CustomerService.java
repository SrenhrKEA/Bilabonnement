package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.entities.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

  Customer getCustomerById(int id) throws Exception;

  List<Customer> getAllCustomers() throws SQLException;

  boolean saveCustomer(Customer customer) throws SQLException;

  boolean updateCustomer(Customer customer) throws SQLException;

  boolean deleteCustomerById(int id) throws SQLException;

}
