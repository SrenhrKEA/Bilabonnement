package com.srenhrkea.eksamensprojekte22.models;

public class Equipment extends EquipmentRef {
  private int idEquipment;

  public Equipment() {
  }

  public Equipment(int idEquipmentRef, String title, String description, double price, int idEquipment) {
    super(idEquipmentRef, title, description, price);
    this.idEquipment = idEquipment;
  }

  public int getIdEquipment() {
    return idEquipment;
  }

  public void setIdEquipment(int idEquipment) {
    this.idEquipment = idEquipment;
  }

  @Override
  public String toString() {
    return "Equipment{" +
        "idEquipment=" + idEquipment +
        '}';
  }
}
