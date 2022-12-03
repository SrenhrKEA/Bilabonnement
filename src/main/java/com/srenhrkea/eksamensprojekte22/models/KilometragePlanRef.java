package com.srenhrkea.eksamensprojekte22.models;

public class KilometragePlanRef {
  private int idKilometragePlanRef;
  private double kilometrage, pricePerMonth;

  public KilometragePlanRef() {
  }

  public KilometragePlanRef(int idKilometragePlanRef, double kilometrage, double pricePerMonth) {
    this.idKilometragePlanRef = idKilometragePlanRef;
    this.kilometrage = kilometrage;
    this.pricePerMonth = pricePerMonth;
  }

  public int getIdKilometragePlanRef() {
    return idKilometragePlanRef;
  }

  public void setIdKilometragePlanRef(int idKilometragePlanRef) {
    this.idKilometragePlanRef = idKilometragePlanRef;
  }

  public double getKilometrage() {
    return kilometrage;
  }

  public void setKilometrage(double kilometrage) {
    this.kilometrage = kilometrage;
  }

  public double getPricePerMonth() {
    return pricePerMonth;
  }

  public void setPricePerMonth(double pricePerMonth) {
    this.pricePerMonth = pricePerMonth;
  }

  @Override
  public String toString() {
    return "KilometragePlanRef{" +
        "idKilometragePlanRef=" + idKilometragePlanRef +
        ", kilometrage=" + kilometrage +
        ", pricePerMonth=" + pricePerMonth +
        '}';
  }
}
