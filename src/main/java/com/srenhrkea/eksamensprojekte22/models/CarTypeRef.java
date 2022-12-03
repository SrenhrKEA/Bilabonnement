package com.srenhrkea.eksamensprojekte22.models;

import com.srenhrkea.eksamensprojekte22.enums.FuelType;
import com.srenhrkea.eksamensprojekte22.enums.TransmissionType;

public class CarTypeRef {
  private int idCarTypeRef, seatingCapacity;
  private double taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth;
  private String brand, model, description;
  private TransmissionType transmissionType;
  private FuelType fuelType;

  public CarTypeRef() {
  }

  public CarTypeRef(int idCarTypeRef, int seatingCapacity, double taxableValue, double registrationTax, double fuelConsumption, double emission, double pricePerMonth, String brand, String model, String description, TransmissionType transmissionType, FuelType fuelType) {
    this.idCarTypeRef = idCarTypeRef;
    this.seatingCapacity = seatingCapacity;
    this.taxableValue = taxableValue;
    this.registrationTax = registrationTax;
    this.fuelConsumption = fuelConsumption;
    this.emission = emission;
    this.pricePerMonth = pricePerMonth;
    this.brand = brand;
    this.model = model;
    this.description = description;
    this.transmissionType = transmissionType;
    this.fuelType = fuelType;
  }

  public int getIdCarTypeRef() {
    return idCarTypeRef;
  }

  public void setIdCarType(int idCarTypeRef) {
    this.idCarTypeRef = idCarTypeRef;
  }

  public int getSeatingCapacity() {
    return seatingCapacity;
  }

  public void setSeatingCapacity(int seatingCapacity) {
    this.seatingCapacity = seatingCapacity;
  }

  public double getTaxableValue() {
    return taxableValue;
  }

  public void setTaxableValue(double taxableValue) {
    this.taxableValue = taxableValue;
  }

  public double getRegistrationTax() {
    return registrationTax;
  }

  public void setRegistrationTax(double registrationTax) {
    this.registrationTax = registrationTax;
  }

  public double getFuelConsumption() {
    return fuelConsumption;
  }

  public void setFuelConsumption(double fuelConsumption) {
    this.fuelConsumption = fuelConsumption;
  }

  public double getEmission() {
    return emission;
  }

  public void setEmission(double emission) {
    this.emission = emission;
  }

  public double getPricePerMonth() {
    return pricePerMonth;
  }

  public void setPricePerMonth(double pricePerMonth) {
    this.pricePerMonth = pricePerMonth;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TransmissionType getTransmissionType() {
    return transmissionType;
  }

  public void setTransmissionType(TransmissionType transmissionType) {
    this.transmissionType = transmissionType;
  }

  public FuelType getFuelType() {
    return fuelType;
  }

  public void setFuelType(FuelType fuelType) {
    this.fuelType = fuelType;
  }

  @Override
  public String toString() {
    return "CarTypeRef{" +
        "idCarTypeRef=" + idCarTypeRef +
        ", seatingCapacity=" + seatingCapacity +
        ", taxableValue=" + taxableValue +
        ", registrationTax=" + registrationTax +
        ", fuelConsumption=" + fuelConsumption +
        ", emission=" + emission +
        ", pricePerMonth=" + pricePerMonth +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", description='" + description + '\'' +
        ", transmissionType=" + transmissionType +
        ", fuelType=" + fuelType +
        '}';
  }
}
