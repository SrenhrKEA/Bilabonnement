package com.srenhrkea.eksamensprojekte22.models;

public class PickupLocationRef {
  private int idPickupLocationRef, postalCode;
  private String address, city;

  public PickupLocationRef() {
  }

  public PickupLocationRef(int idPickupLocationRef, int postalCode, String address, String city) {
    this.idPickupLocationRef = idPickupLocationRef;
    this.postalCode = postalCode;
    this.address = address;
    this.city = city;
  }

  public int getIdPickupLocationRef() {
    return idPickupLocationRef;
  }

  public void setIdPickupLocationRef(int idPickupLocationRef) {
    this.idPickupLocationRef = idPickupLocationRef;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
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

  @Override
  public String toString() {
    return "PickupLocationRef{" +
        "idPickupLocationRef=" + idPickupLocationRef +
        ", postalCode=" + postalCode +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}
