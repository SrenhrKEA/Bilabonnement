/*User*/
INSERT INTO user (username, ´password´, userType)
VALUES ('John', '123', 'ADMIN');
INSERT INTO user (username, ´password´, userType)
VALUES ('Sophie', '123', 'DAMAGE_REG');
INSERT INTO user (username, ´password´, userType)
VALUES ('Jesus', '123', 'DATA_REG');
INSERT INTO user (username, ´password´, userType)
VALUES ('Bob', '123', 'BUSINESS');

/*Customer*/
INSERT INTO Customer
( licenceNo, postalCode, givenname, lastname, address, city, contactNo, email)
VALUES (55560, 2990, 'John', 'Johnson', 'Stationsvej 9', 'Nivå', '+4566600066', 'John@kea.dk');
INSERT INTO Customer
( licenceNo, postalCode, givenname, lastname, address, city, contactNo, email)
VALUES (55578, 2400, 'Nanna', 'Mortensen', 'Emdrup Torv 10', 'Emdrup', '+4500006666', 'Nanna@kea.dk');

/*Lease*/
INSERT INTO Lease
( durationMonths, dateOfRent, DateOfReturn, subscriptionType, CustomeridCustomer)
VALUES (5, '2022-12-04', '2022-12-05', 'LIMITED', '1');
INSERT INTO Lease
( durationMonths, dateOfRent, DateOfReturn, subscriptionType, CustomeridCustomer)
VALUES (12, '2022-12-05', '2022-12-06', 'UNLIMITED', '2');

/*CarTypeRef*/
INSERT INTO CarTypeRef
(seatingCapacity, taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth, brand, model,
 ´description´, transmissionType, fuelType)
VALUES (5, 1000, 500, 20, 30, 4000, 'Opel', 'Corsa', 'God familie bil', 'MANUAL', 'GASOLINE');
INSERT INTO CarTypeRef
(seatingCapacity, taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth, brand, model,
 ´description´, transmissionType, fuelType)
VALUES (5, 1000, 500, 20, 30, 4000, 'Opel', 'Cadet', 'Mæ og min kadet', 'MANUAL', 'DIESEL');

/*Car*/
INSERT INTO Car
(idCarVIN, isAvailable, initialKilometrage, regNo, LeaseidLease, CarTypeRefidCarTypeRef)
VALUES ('666666DK', 1, 1000, 'MINDYT69', 1, 1);
INSERT INTO Car
(idCarVIN, isAvailable, initialKilometrage, regNo, LeaseidLease, CarTypeRefidCarTypeRef)
VALUES ('888888DK', 0, 2000, 'MINKADET', 2, 2);


