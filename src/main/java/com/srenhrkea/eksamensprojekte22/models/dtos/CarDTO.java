package com.srenhrkea.eksamensprojekte22.models.dtos;

public class CarDTO {
  private boolean isAvailable;
  private int idCarType, idLease;
  private double initialKilometrage;
  private String idCarVIN, regNo;

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public int getIdCarType() {
    return idCarType;
  }

  public void setIdCarType(int idCarType) {
    this.idCarType = idCarType;
  }

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
  }

  public double getInitialKilometrage() {
    return initialKilometrage;
  }

  public void setInitialKilometrage(double initialKilometrage) {
    this.initialKilometrage = initialKilometrage;
  }

  public String getIdCarVIN() {
    return idCarVIN;
  }

  public void setIdCarVIN(String idCarVIN) {
    this.idCarVIN = idCarVIN;
  }

  public String getRegNo() {
    return regNo;
  }

  public void setRegNo(String regNo) {
    this.regNo = regNo;
  }
}
