package com.srenhrkea.eksamensprojekte22.models;

public class PickupLocation extends PickupLocationRef {
  private int idPickupLocation;

  public PickupLocation() {
  }

  public PickupLocation(int idPickupLocationRef, int postalCode, String address, String city, int idPickupLocation) {
    super(idPickupLocationRef, postalCode, address, city);
    this.idPickupLocation = idPickupLocation;
  }

  public int getIdPickupLocation() {
    return idPickupLocation;
  }

  public void setIdPickupLocation(int idPickupLocation) {
    this.idPickupLocation = idPickupLocation;
  }

  @Override
  public String toString() {
    return "PickupLocation{" +
        "idPickupLocation=" + idPickupLocation +
        '}';
  }
}
