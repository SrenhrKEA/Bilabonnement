SELECT idCarVIN, isAvailable, initialKilometrage, regNo, LeaseidLease, CarTypeRefidCarTypeRef
FROM Car;
SELECT idCarTypeRef,
       seatingCapacity,
       taxableValue,
       registrationTax,
       fuelConsumption,
       emission,
       pricePerMonth,
       brand,
       model,
       ´description´,
       transmissionType,
       fuelType
FROM CarTypeRef;
SELECT idCustomer,
       licenceNo,
       postalCode,
       givenname,
       lastname,
       address,
       city,
       contactNo,
       email
FROM Customer;
SELECT idDamage, DamageReportidDamageReport, title, ´description´, price
FROM Damage;
SELECT idDamageReport, dateOfReport, CaridCarVIN
FROM DamageReport;
SELECT idEquipment, LeaseidLease, EquipmentRefidEquipmentRef
FROM Equipment;
SELECT idEquipmentRef, title, ´description´, price
FROM EquipmentRef;
SELECT idKilometragePlan, LeaseidLease, KilometragePlanRefidKilometragePlanRef
FROM KilometragePlan;
SELECT idKilometragePlanRef, kilometrage, pricePerMonth
FROM KilometragePlanRef;
SELECT idLease, durationMonths, dateOfRent, DateOfReturn, subscriptionType, CustomeridCustomer
FROM Lease;
SELECT idPickupLocation, LeaseidLease, PickupLocationRefidPickupLocationRef
FROM PickupLocation;
SELECT idPickupLocationRef, address, city, postalCode
FROM PickupLocationRef;
SELECT username, ´password´, userType
FROM `User`;

