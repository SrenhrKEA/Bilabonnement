package com.srenhrkea.eksamensprojekte22.models;

public class Car extends CarTypeRef {
  private boolean isAvailable;
  private int idCarType, idLease;
  private double initialKilometrage;
  private String idCarVIN, regNo;

  public Car() {
  }

  public Car(boolean isAvailable, int idCarType, int idLease, double initialKilometrage, String idCarVIN, String regNo) {
    this.isAvailable = isAvailable;
    this.idCarType = idCarType;
    this.idLease = idLease;
    this.initialKilometrage = initialKilometrage;
    this.idCarVIN = idCarVIN;
    this.regNo = regNo;
  }

/*  public Car(int idCarTypeRef, int seatingCapacity, double taxableValue, double registrationTax, double fuelConsumption, double emission, double pricePerMonth, String brand, String model, String description, TransmissionType transmissionType, FuelType fuelType, boolean isAvailable, int idCarType, int idLease, double initialKilometrage, String idCarVIN, String regNo) {
    super(idCarTypeRef, seatingCapacity, taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth, brand, model, description, transmissionType, fuelType);
    this.isAvailable = isAvailable;
    this.idCarType = idCarType;
    this.idLease = idLease;
    this.initialKilometrage = initialKilometrage;
    this.idCarVIN = idCarVIN;
    this.regNo = regNo;
  }*/

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public int getIdCarType() {
    return idCarType;
  }

  @Override
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

  @Override
  public String toString() {
    return "Car{" +
        "isAvailable=" + isAvailable +
        ", idCarType=" + idCarType +
        ", idLease=" + idLease +
        ", initialKilometrage=" + initialKilometrage +
        ", idCarVIN='" + idCarVIN + '\'' +
        ", regNo='" + regNo + '\'' +
        '}';
  }
}
