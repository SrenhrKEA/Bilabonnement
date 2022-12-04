package com.srenhrkea.eksamensprojekte22.services;

import com.srenhrkea.eksamensprojekte22.models.Customer;

import java.util.List;

public interface CustomerService {

  Customer getCustomerById(int id);

  List<Customer> getAllCustomers();

  void saveCustomer(Customer customer);

  void updateCustomer(Customer customer);

  void deleteCustomerById(int id);

}
