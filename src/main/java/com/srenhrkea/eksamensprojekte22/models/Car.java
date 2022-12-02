package com.srenhrkea.eksamensprojekte22.models;

import com.srenhrkea.eksamensprojekte22.enums.FuelType;
import com.srenhrkea.eksamensprojekte22.enums.TransmissionType;

public class Car extends CarType {
  private boolean isAvailable;
  private int carTypeId;
  private double initialKilometrage;
  private String id, regNo; //ID is the cars VIN
}
