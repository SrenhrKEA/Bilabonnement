package com.srenhrkea.eksamensprojekte22.models.dtos;

public class PickupLocationDTO {
  private int idPickupLocationRef, idLease;

  public int getIdPickupLocationRef() {
    return idPickupLocationRef;
  }

  public void setIdPickupLocationRef(int idPickupLocationRef) {
    this.idPickupLocationRef = idPickupLocationRef;
  }

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
  }
}
