package com.srenhrkea.eksamensprojekte22.models;

public class Equipment extends EquipmentRef {
  private int idEquipment, idEquipmentRef, idLease;

  public Equipment() {
  }

  public Equipment(int idEquipment, int idEquipmentRef, int idLease) {
    this.idEquipment = idEquipment;
    this.idEquipmentRef = idEquipmentRef;
    this.idLease = idLease;
  }

/*  public Equipment(int idEquipmentRef, String title, String description, double price, int idEquipment, int idEquipmentRef1, int idLease) {
    super(idEquipmentRef, title, description, price);
    this.idEquipment = idEquipment;
    this.idEquipmentRef = idEquipmentRef1;
    this.idLease = idLease;
  }*/

  public int getIdEquipment() {
    return idEquipment;
  }

  public void setIdEquipment(int idEquipment) {
    this.idEquipment = idEquipment;
  }

  @Override
  public int getIdEquipmentRef() {
    return idEquipmentRef;
  }

  @Override
  public void setIdEquipmentRef(int idEquipmentRef) {
    this.idEquipmentRef = idEquipmentRef;
  }

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
  }

  @Override
  public String toString() {
    return "Equipment{" +
        "idEquipment=" + idEquipment +
        ", idEquipmentRef=" + idEquipmentRef +
        ", idLease=" + idLease +
        '}';
  }
}
