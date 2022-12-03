UPDATE Car
SET isAvailable            = ?,
    initialKilometrage     = ?,
    regNo                  = ?,
    LeaseidLease           = ?,
    CarTypeRefidCarTypeRef = ?
WHERE idCarVIN = ?;
UPDATE CarTypeRef
SET seatingCapacity  = ?,
    taxableValue     = ?,
    registrationTax  = ?,
    fuelConsumption  = ?,
    emission         = ?,
    pricePerMonth    = ?,
    brand            = ?,
    model            = ?,
    ´description´      = ?,
    transmissionType = ?,
    fuelType         = ?
WHERE idCarTypeRef = ?;
UPDATE Customer
SET licenceNo  = ?,
    postalCode = ?,
    givenname  = ?,
    lastname   = ?,
    address    = ?,
    city       = ?,
    contactNo  = ?,
    email      = ?
WHERE idCustomer = ?;
UPDATE Damage
SET DamageReportidDamageReport = ?,
    title                      = ?,
    ´description´                = ?,
    price                      = ?
WHERE idDamage = ?;
UPDATE DamageReport
SET dateOfReport = ?,
    CaridCarVIN  = ?
WHERE idDamageReport = ?;
UPDATE Equipment
SET LeaseidLease               = ?,
    EquipmentRefidEquipmentRef = ?
WHERE idEquipment = ?;
UPDATE EquipmentRef
SET title       = ?,
    ´description´ = ?,
    price       = ?
WHERE idEquipmentRef = ?;
UPDATE KilometragePlan
SET LeaseidLease                           = ?,
    KilometragePlanRefidKilometragePlanRef = ?
WHERE idKilometragePlan = ?;
UPDATE KilometragePlanRef
SET kilometrage   = ?,
    pricePerMonth = ?
WHERE idKilometragePlanRef = ?;
UPDATE Lease
SET durationMonths     = ?,
    dateOfRent         = ?,
    DateOfReturn       = ?,
    subscriptionType   = ?,
    CustomeridCustomer = ?
WHERE idLease = ?;
UPDATE PickupLocation
SET LeaseidLease                         = ?,
    PickupLocationRefidPickupLocationRef = ?
WHERE idPickupLocation = ?;
UPDATE PickupLocationRef
SET address    = ?,
    city       = ?,
    postalCode = ?
WHERE idPickupLocationRef = ?;
UPDATE `User`
SET ´password´ = ?,
    userType = ?
WHERE username = ?;

