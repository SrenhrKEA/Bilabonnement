package com.srenhrkea.eksamensprojekte22.models;

public class EquipmentRef {
  private int idEquipmentRef;
  private String title, description;
  private double price;

  public EquipmentRef() {
  }

  public EquipmentRef(int idEquipmentRef, String title, String description, double price) {
    this.idEquipmentRef = idEquipmentRef;
    this.title = title;
    this.description = description;
    this.price = price;
  }

  public int getIdEquipmentRef() {
    return idEquipmentRef;
  }

  public void setIdEquipmentRef(int idEquipmentRef) {
    this.idEquipmentRef = idEquipmentRef;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "EquipmentRef{" +
        "idEquipmentRef=" + idEquipmentRef +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        '}';
  }
}
