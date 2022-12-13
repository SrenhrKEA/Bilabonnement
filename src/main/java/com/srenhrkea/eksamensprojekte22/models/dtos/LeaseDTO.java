package com.srenhrkea.eksamensprojekte22.models.dtos;

import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class LeaseDTO {
  private int idLease, durationMonths, idCustomer;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfRent, dateOfReturn;
  private SubscriptionType subscriptionType;
  private String idCarVIN;

  public int getIdLease() {
    return idLease;
  }

  public void setIdLease(int idLease) {
    this.idLease = idLease;
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

  public String getIdCarVIN() {
    return idCarVIN;
  }

  public void setIdCarVIN(String idCarVIN) {
    this.idCarVIN = idCarVIN;
  }
}
