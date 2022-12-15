package com.srenhrkea.eksamensprojekte22.dtos;

public class CarDTO {
  private boolean isAvailable;
  private int idCarTypeRef;
  private double initialKilometrage;
  private String idCarVIN, regNo;

  public boolean getIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(boolean available) {
    isAvailable = available;
  }

  public int getIdCarTypeRef() {
    return idCarTypeRef;
  }

  public void setIdCarTypeRef(int idCarTypeRef) {
    this.idCarTypeRef = idCarTypeRef;
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
