package com.srenhrkea.eksamensprojekte22.models;

public class KilometragePlan extends KilometragePlanRef {
  private int idKilometragePlan;

  public KilometragePlan() {
  }

  public KilometragePlan(int idKilometragePlanRef, double kilometrage, double pricePerMonth, int idKilometragePlan) {
    super(idKilometragePlanRef, kilometrage, pricePerMonth);
    this.idKilometragePlan = idKilometragePlan;
  }

  public int getIdKilometragePlan() {
    return idKilometragePlan;
  }

  public void setIdKilometragePlan(int idKilometragePlan) {
    this.idKilometragePlan = idKilometragePlan;
  }

  @Override
  public String toString() {
    return "KilometragePlan{" +
        "idKilometragePlan=" + idKilometragePlan +
        '}';
  }
}
