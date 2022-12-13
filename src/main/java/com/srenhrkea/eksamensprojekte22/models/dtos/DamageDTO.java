package com.srenhrkea.eksamensprojekte22.models.dtos;

public class DamageDTO {

  private int idDamage, idDamageReport;
  private double price;
  private String title, description;

  public int getIdDamage() {
    return idDamage;
  }

  public void setIdDamage(int idDamage) {
    this.idDamage = idDamage;
  }

  public int getIdDamageReport() {
    return idDamageReport;
  }

  public void setIdDamageReport(int idDamageReport) {
    this.idDamageReport = idDamageReport;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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
}
