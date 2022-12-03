package com.srenhrkea.eksamensprojekte22.models;

public class Customer {
  private int idCustomer, licenceNo, postalCode;
  private String givenname, lastname, address, city, contactNo, email;

  public Customer() {
  }

  public Customer(int idCustomer, int licenceNo, int postalCode, String givenname, String lastname, String address, String city, String contactNo, String email) {
    this.idCustomer = idCustomer;
    this.licenceNo = licenceNo;
    this.postalCode = postalCode;
    this.givenname = givenname;
    this.lastname = lastname;
    this.address = address;
    this.city = city;
    this.contactNo = contactNo;
    this.email = email;
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

  public String getGivenname() {
    return givenname;
  }

  public void setGivenname(String givenname) {
    this.givenname = givenname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
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

  @Override
  public String toString() {
    return "Customer{" +
        "idCustomer=" + idCustomer +
        ", licenceNo=" + licenceNo +
        ", postalCode=" + postalCode +
        ", givenname='" + givenname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", contactNo='" + contactNo + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
