DELETE
FROM Car
WHERE idCarVIN = ?;
DELETE
FROM CarTypeRef
WHERE idCarTypeRef = ?;
DELETE
FROM Customer
WHERE idCustomer = ?;
DELETE
FROM Damage
WHERE idDamage = ?;
DELETE
FROM DamageReport
WHERE idDamageReport = ?;
DELETE
FROM Equipment
WHERE idEquipment = ?;
DELETE
FROM EquipmentRef
WHERE idEquipmentRef = ?;
DELETE
FROM KilometragePlan
WHERE idKilometragePlan = ?;
DELETE
FROM KilometragePlanRef
WHERE idKilometragePlanRef = ?;
DELETE
FROM Lease
WHERE idLease = ?;
DELETE
FROM PickupLocation
WHERE idPickupLocation = ?;
DELETE
FROM PickupLocationRef
WHERE idPickupLocationRef = ?;
DELETE
FROM `User`
WHERE username = ?;

