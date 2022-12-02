package com.srenhrkea.eksamensprojekte22.models;

import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;

import java.util.Date;

public class Lease {
  private int id, durationMonths, idCustomer, carId, idOptional, idPickupLocation;
  private Date dateOfRent, DateOfReturn;
  private SubscriptionType subscriptionType;
}
