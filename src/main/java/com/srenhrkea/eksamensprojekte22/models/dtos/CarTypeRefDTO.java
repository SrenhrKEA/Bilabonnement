package com.srenhrkea.eksamensprojekte22.models.dtos;

import com.srenhrkea.eksamensprojekte22.enums.FuelType;
import com.srenhrkea.eksamensprojekte22.enums.TransmissionType;

public class CarTypeRefDTO {

  private int idCarTypeRef, seatingCapacity;
  private double taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth;
  private String brand, model, description;
  private TransmissionType transmissionType;
  private FuelType fuelType;

  public int getIdCarTypeRef() {
    return idCarTypeRef;
  }

  public void setIdCarTypeRef(int idCarTypeRef) {
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
}
