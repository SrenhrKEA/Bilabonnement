package com.srenhrkea.eksamensprojekte22.models;

public class Customer {
  private int idCustomer, postalCode;
  private String firstName, lastName, address, city, contactNo, email, nationality, licenceNo;

  public Customer() {
  }

  public Customer(int idCustomer, int postalCode, String firstName, String lastName, String address, String city, String contactNo, String email, String nationality, String licenceNo) {
    this.idCustomer = idCustomer;
    this.postalCode = postalCode;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.contactNo = contactNo;
    this.email = email;
    this.nationality = nationality;
    this.licenceNo = licenceNo;
  }

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
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

  public String getLicenceNo() {
    return licenceNo;
  }

  public void setLicenceNo(String licenceNo) {
    this.licenceNo = licenceNo;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "idCustomer=" + idCustomer +
        ", postalCode=" + postalCode +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", contactNo='" + contactNo + '\'' +
        ", email='" + email + '\'' +
        ", nationality='" + nationality + '\'' +
        ", licenceNo='" + licenceNo + '\'' +
        '}';
  }
}
