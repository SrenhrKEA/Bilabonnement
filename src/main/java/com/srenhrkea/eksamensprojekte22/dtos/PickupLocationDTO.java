package com.srenhrkea.eksamensprojekte22.dtos;

public class PickupLocationDTO {
  private int idPickupLocation, idPickupLocationRef, idLease;

  public int getIdPickupLocation() {
    return idPickupLocation;
  }

  public void setIdPickupLocation(int idPickupLocation) {
    this.idPickupLocation = idPickupLocation;
  }

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
