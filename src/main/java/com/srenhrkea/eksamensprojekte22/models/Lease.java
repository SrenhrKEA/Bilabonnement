package com.srenhrkea.eksamensprojekte22.models;

import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Lease {
  private int idLease, durationMonths, idCustomer;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfRent, dateOfReturn;
  private SubscriptionType subscriptionType;
  private String idCarVIN;

  public Lease() {
  }

  public Lease(int idLease, int durationMonths, int idCustomer, LocalDate dateOfRent, LocalDate dateOfReturn, SubscriptionType subscriptionType, String idCarVIN) {
    this.idLease = idLease;
    this.durationMonths = durationMonths;
    this.idCustomer = idCustomer;
    this.dateOfRent = dateOfRent;
    this.dateOfReturn = dateOfReturn;
    this.subscriptionType = subscriptionType;
    this.idCarVIN = idCarVIN;
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

  public LocalDate getDateOfRent() {
    return dateOfRent;
  }

  public void setDateOfRent(LocalDate dateOfRent) {
    this.dateOfRent = dateOfRent;
  }

  public LocalDate getDateOfReturn() {
    return dateOfReturn;
  }

  public void setDateOfReturn(LocalDate dateOfReturn) {
    this.dateOfReturn = dateOfReturn;
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
        ", dateOfReturn=" + dateOfReturn +
        ", subscriptionType=" + subscriptionType +
        '}';
  }
}
