package com.srenhrkea.eksamensprojekte22.daos.impl;

import com.srenhrkea.eksamensprojekte22.daos.CustomerDAO;
import com.srenhrkea.eksamensprojekte22.models.Customer;
import com.srenhrkea.eksamensprojekte22.utilities.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

  private Connection conn = DatabaseConnectionManager.getConnection();

  @Override
  public Optional<Customer> get(Integer id) {
    Customer customer = null;
    String sql = "SELECT *FROM customer WHERE idCustomer=?";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      ResultSet rs = psts.executeQuery();
      if (rs.next()) {
        int idCustomer = rs.getInt("idCustomer");
        int licenceNo = rs.getInt("licenceNo");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int postalCode = rs.getInt("postalCode");
        String contactNo = rs.getString("contactNo");
        String email = rs.getString("email");
        String nationality = rs.getString("nationality");

        customer = new Customer();
        customer.setIdCustomer(idCustomer);
        customer.setLicenceNo(licenceNo);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setPostalCode(postalCode);
        customer.setContactNo(contactNo);
        customer.setEmail(email);
        customer.setNationality(nationality);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    assert customer != null;
    return Optional.of(customer);
  }

  @Override
  public Collection<Customer> getAll() {

    List<Customer> customers = new ArrayList<>();
    String sql = "SELECT *FROM customer";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      ResultSet rs = psts.executeQuery();
      while (rs.next()) {
        int idCustomer = rs.getInt("idCustomer");
        int licenceNo = rs.getInt("licenceNo");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int postalCode = rs.getInt("postalCode");
        String contactNo = rs.getString("contactNo");
        String email = rs.getString("email");
        String nationality = rs.getString("nationality");

        Customer customer = new Customer();
        customer.setIdCustomer(idCustomer);
        customer.setLicenceNo(licenceNo);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setPostalCode(postalCode);
        customer.setContactNo(contactNo);
        customer.setEmail(email);
        customer.setNationality(nationality);

        customers.add(customer);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return customers;
  }

  @Override
  public boolean save(Customer customer) {

    String sql = "INSERT INTO customer (licenceNo,firstName,lastName,address,city,postalCode,contactNo,email,nationality)VALUES(?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, customer.getLicenceNo());
      psts.setString(2, customer.getFirstName());
      psts.setString(3, customer.getLastName());
      psts.setString(4, customer.getAddress());
      psts.setString(5, customer.getCity());
      psts.setInt(6, customer.getPostalCode());
      psts.setString(7, customer.getContactNo());
      psts.setString(8, customer.getEmail());
      psts.setString(9, customer.getNationality());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Customer is saved.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean update(Customer customer) {

    String sql = "UPDATE customer set licenceNo=?, firstName=?, lastName=?, address=?,city=?,postalCode=?, contactNo=?, email=?, nationality=? WHERE idCustomer=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, customer.getLicenceNo());
      psts.setString(2, customer.getFirstName());
      psts.setString(3, customer.getLastName());
      psts.setString(4, customer.getAddress());
      psts.setString(5, customer.getCity());
      psts.setInt(6, customer.getPostalCode());
      psts.setString(7, customer.getContactNo());
      psts.setString(8, customer.getEmail());
      psts.setString(9, customer.getNationality());
      psts.setInt(10, customer.getIdCustomer());

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Customer is updated.");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Integer id) {

    String sql = "DELETE FROM customer WHERE idCustomer=?;";
    try (PreparedStatement psts = conn.prepareStatement(sql)) {

      psts.setInt(1, id);

      int executeUpdate = psts.executeUpdate();

      if (executeUpdate == 1) {
        System.out.println("Customer with ID " + id + " is deleted.::");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
