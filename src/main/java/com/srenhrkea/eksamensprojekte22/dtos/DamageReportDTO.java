package com.srenhrkea.eksamensprojekte22.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DamageReportDTO {

  private int idDamageReport;
  private String idCarVIN;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfReport;

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
}
