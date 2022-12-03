INSERT INTO Car
(idCarVIN,
 isAvailable,
 initialKilometrage,
 regNo,
 LeaseidLease,
 CarTypeRefidCarTypeRef)
VALUES (?,
        ?,
        ?,
        ?,
        ?,
        ?);
INSERT INTO CarTypeRef
(idCarTypeRef,
 seatingCapacity,
 taxableValue,
 registrationTax,
 fuelConsumption,
 emission,
 pricePerMonth,
 brand,
 model,
 description,
 transmissionType,
 fuelType)
VALUES (?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?);
INSERT INTO Customer
(idCustomer,
 licenceNo,
 postalCode,
 givenname,
 lastname,
 address,
 city,
 contactNo,
 email)
VALUES (?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?,
        ?);
INSERT INTO Damage
(idDamage,
 DamageReportidDamageReport,
 title,
 description,
 price)
VALUES (?,
        ?,
        ?,
        ?,
        ?);
INSERT INTO DamageReport
(idDamageReport,
 dateOfReport,
 CaridCarVIN)
VALUES (?,
        ?,
        ?);
INSERT INTO Equipment
(idEquipment,
 LeaseidLease,
 EquipmentRefidEquipmentRef)
VALUES (?,
        ?,
        ?);
INSERT INTO EquipmentRef
(idEquipmentRef,
 title,
 description,
 price)
VALUES (?,
        ?,
        ?,
        ?);
INSERT INTO KilometragePlan
(idKilometragePlan,
 LeaseidLease,
 KilometragePlanRefidKilometragePlanRef)
VALUES (?,
        ?,
        ?);
INSERT INTO KilometragePlanRef
(idKilometragePlanRef,
 kilometrage,
 pricePerMonth,
 LeaseidLease)
VALUES (?,
        ?,
        ?,
        ?);
INSERT INTO Lease
(idLease,
 durationMonths,
 dateOfRent,
 DateOfReturn,
 subscriptionType,
 CustomeridCustomer)
VALUES (?,
        ?,
        ?,
        ?,
        ?,
        ?);
INSERT INTO PickupLocation
(idLocation,
 LeaseidLease,
 PickupLocationRefidPickupLocationRef)
VALUES (?,
        ?,
        ?);
INSERT INTO PickupLocationRef
(idPickupLocationRef,
 address,
 city,
 postalCode)
VALUES (?,
        ?,
        ?,
        ?);
INSERT INTO `User`
(username,
 password,
 userType)
VALUES (?,
        ?,
        ?);

