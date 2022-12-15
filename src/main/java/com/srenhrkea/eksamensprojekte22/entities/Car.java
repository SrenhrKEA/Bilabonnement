package com.srenhrkea.eksamensprojekte22.entities;

public class Car extends CarTypeRef {
  private boolean isAvailable;
  private int idCarTypeRef;
  private double initialKilometrage;
  private String idCarVIN, regNo;

  public Car() {
  }

  public Car(boolean isAvailable, int idCarTypeRef, double initialKilometrage, String idCarVIN, String regNo) {
    this.isAvailable = isAvailable;
    this.idCarTypeRef = idCarTypeRef;
    this.initialKilometrage = initialKilometrage;
    this.idCarVIN = idCarVIN;
    this.regNo = regNo;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  @Override
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

  @Override
  public String toString() {
    return "Car{" +
        "isAvailable=" + isAvailable +
        ", idCarTypeRef=" + idCarTypeRef +
        ", initialKilometrage=" + initialKilometrage +
        ", idCarVIN='" + idCarVIN + '\'' +
        ", regNo='" + regNo + '\'' +
        '}';
  }
}
