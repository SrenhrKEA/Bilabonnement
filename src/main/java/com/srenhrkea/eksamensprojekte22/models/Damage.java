package com.srenhrkea.eksamensprojekte22.models;

public class Damage {
  private int idDamage, idDamageReport;
  private double price;
  private String title, description;

  public Damage() {
  }

  public Damage(int idDamage, int idDamageReport, double price, String title, String description) {
    this.idDamage = idDamage;
    this.idDamageReport = idDamageReport;
    this.price = price;
    this.title = title;
    this.description = description;
  }

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

  @Override
  public String toString() {
    return "Damage{" +
        "idDamage=" + idDamage +
        ", price=" + price +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
