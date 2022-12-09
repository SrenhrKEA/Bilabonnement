package com.srenhrkea.eksamensprojekte22.models;

public class PickupLocation extends PickupLocationRef {
  private int idPickupLocation, idPickupLocationRef, idLease;

  public PickupLocation() {
  }

  public PickupLocation(int idPickupLocation, int idPickupLocationRef, int idLease) {
    this.idPickupLocation = idPickupLocation;
    this.idPickupLocationRef = idPickupLocationRef;
    this.idLease = idLease;
  }

  public int getIdPickupLocation() {
    return idPickupLocation;
  }

  public void setIdPickupLocation(int idPickupLocation) {
    this.idPickupLocation = idPickupLocation;
  }

  @Override
  public int getIdPickupLocationRef() {
    return idPickupLocationRef;
  }

  @Override
  public void setIdPickupLocationRef(int idPickupLocationRef) {
    this.idPickupLocationRef = idPickupLocationRef;
  }

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
  }

  @Override
  public String toString() {
    return "PickupLocation{" +
        "idPickupLocation=" + idPickupLocation +
        ", idPickupLocationRef=" + idPickupLocationRef +
        ", idLease=" + idLease +
        '}';
  }
}
