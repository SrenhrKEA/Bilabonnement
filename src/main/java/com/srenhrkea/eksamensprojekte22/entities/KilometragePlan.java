package com.srenhrkea.eksamensprojekte22.entities;

public class KilometragePlan extends KilometragePlanRef {
  private int idKilometragePlan, idKilometragePlanRef, idLease;

  public KilometragePlan() {
  }

  public KilometragePlan(int idKilometragePlan, int idKilometragePlanRef, int idLease) {
    this.idKilometragePlan = idKilometragePlan;
    this.idKilometragePlanRef = idKilometragePlanRef;
    this.idLease = idLease;
  }

  public int getIdKilometragePlan() {
    return idKilometragePlan;
  }

  public void setIdKilometragePlan(int idKilometragePlan) {
    this.idKilometragePlan = idKilometragePlan;
  }

  @Override
  public int getIdKilometragePlanRef() {
    return idKilometragePlanRef;
  }

  @Override
  public void setIdKilometragePlanRef(int idKilometragePlanRef) {
    this.idKilometragePlanRef = idKilometragePlanRef;
  }

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
  }

  @Override
  public String toString() {
    return "KilometragePlan{" +
        "idKilometragePlan=" + idKilometragePlan +
        ", idKilometragePlanRef=" + idKilometragePlanRef +
        ", idLease=" + idLease +
        '}';
  }
}
