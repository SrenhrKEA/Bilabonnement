package com.srenhrkea.eksamensprojekte22.models;

public class Customer {
  private int idCustomer, licenceNo, postalCode;
  private String firstName, lastName, address, city, contactNo, email, nationality;

  public Customer() {
  }

  public Customer(int idCustomer, int licenceNo, int postalCode, String firstName, String lastName, String address, String city, String contactNo, String email, String nationality) {
    this.idCustomer = idCustomer;
    this.licenceNo = licenceNo;
    this.postalCode = postalCode;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.contactNo = contactNo;
    this.email = email;
    this.nationality = nationality;
  }

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  public int getLicenceNo() {
    return licenceNo;
  }

  public void setLicenceNo(int licenceNo) {
    this.licenceNo = licenceNo;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getContactNo() {
    return contactNo;
  }

  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "idCustomer=" + idCustomer +
        ", licenceNo=" + licenceNo +
        ", postalCode=" + postalCode +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", contactNo='" + contactNo + '\'' +
        ", email='" + email + '\'' +
        ", nationality='" + nationality + '\'' +
        '}';
  }
}
