package com.srenhrkea.eksamensprojekte22.models;

import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;

import java.util.Date;

public class Lease {
  private int idLease, durationMonths, idCustomer;
  private Date dateOfRent, DateOfReturn;
  private SubscriptionType subscriptionType;

  private String idCarVIN;

  public Lease() {
  }

  public Lease(int idLease, String idCarVIN, int durationMonths, int idCustomer, Date dateOfRent, Date dateOfReturn, SubscriptionType subscriptionType) {
    this.idLease = idLease;
    this.idCarVIN = idCarVIN;
    this.durationMonths = durationMonths;
    this.idCustomer = idCustomer;
    this.dateOfRent = dateOfRent;
    DateOfReturn = dateOfReturn;
    this.subscriptionType = subscriptionType;
  }

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
  }

  public String getIdCarVIN() {
    return idCarVIN;
  }

  public void setIdCarVIN(String idCarVIN) {
    this.idCarVIN = idCarVIN;
  }

  public int getDurationMonths() {
    return durationMonths;
  }

  public void setDurationMonths(int durationMonths) {
    this.durationMonths = durationMonths;
  }

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  public Date getDateOfRent() {
    return dateOfRent;
  }

  public void setDateOfRent(Date dateOfRent) {
    this.dateOfRent = dateOfRent;
  }

  public Date getDateOfReturn() {
    return DateOfReturn;
  }

  public void setDateOfReturn(Date dateOfReturn) {
    DateOfReturn = dateOfReturn;
  }

  public SubscriptionType getSubscriptionType() {
    return subscriptionType;
  }

  public void setSubscriptionType(SubscriptionType subscriptionType) {
    this.subscriptionType = subscriptionType;
  }

  @Override
  public String toString() {
    return "Lease{" +
        "idLease=" + idLease +
        ", idCarVIN=" + idCarVIN +
        ", durationMonths=" + durationMonths +
        ", idCustomer=" + idCustomer +
        ", dateOfRent=" + dateOfRent +
        ", DateOfReturn=" + DateOfReturn +
        ", subscriptionType=" + subscriptionType +
        '}';
  }
}
