package com.srenhrkea.eksamensprojekte22.models;

import java.util.Date;

public class DamageReport {
  private int idDamageReport;
  private String idCarVIN;
  private Date dateOfReport;

  public DamageReport() {
  }

  public DamageReport(int idDamageReport, String idCarVIN, Date dateOfReport) {
    this.idDamageReport = idDamageReport;
    this.idCarVIN = idCarVIN;
    this.dateOfReport = dateOfReport;
  }

  public int getIdDamageReport() {
    return idDamageReport;
  }

  public void setIdDamageReport(int idDamageReport) {
    this.idDamageReport = idDamageReport;
  }

  public String getIdCarVIN() {
    return idCarVIN;
  }

  public void setIdCarVIN(String idCarVIN) {
    this.idCarVIN = idCarVIN;
  }

  public Date getDateOfReport() {
    return dateOfReport;
  }

  public void setDateOfReport(Date dateOfReport) {
    this.dateOfReport = dateOfReport;
  }

  @Override
  public String toString() {
    return "DamageReport{" +
        "idDamageReport=" + idDamageReport +
        ", idCarVIN='" + idCarVIN + '\'' +
        ", dateOfReport=" + dateOfReport +
        '}';
  }
}
