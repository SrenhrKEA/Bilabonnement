package com.srenhrkea.eksamensprojekte22.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DamageReport {
  private int idDamageReport;
  private String idCarVIN;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfReport;

  public DamageReport() {
  }

  public DamageReport(int idDamageReport, String idCarVIN, LocalDate dateOfReport) {
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

  public LocalDate getDateOfReport() {
    return dateOfReport;
  }

  public void setDateOfReport(LocalDate dateOfReport) {
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
