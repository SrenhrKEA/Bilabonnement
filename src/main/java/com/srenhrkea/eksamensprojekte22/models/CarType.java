package com.srenhrkea.eksamensprojekte22.models;

import com.srenhrkea.eksamensprojekte22.enums.FuelType;
import com.srenhrkea.eksamensprojekte22.enums.TransmissionType;

public class CarType {
  private int id, seatingCapacity;
  private double taxableValue, registrationTax, fuelConsumption, emission, priceMonthly;
  private String brand, model, type, description;
  private TransmissionType transmissionType;
  private FuelType fuelType;
}
