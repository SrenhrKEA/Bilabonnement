/*User*/
INSERT INTO user (username, ´password´, userType)
VALUES ('ADMIN', 'ADMIN', 'ADMIN');
INSERT INTO user (username, ´password´, userType)
VALUES ('John', '123', 'DAMAGE_REG');
INSERT INTO user (username, ´password´, userType)
VALUES ('Jesus', '123', 'DATA_REG');
INSERT INTO user (username, ´password´, userType)
VALUES ('Bob', '123', 'BUSINESS');

/*Customer*/
/*INSERT INTO Customer
(licenceNo, postalCode, givenname, lastname, address, city, contactNo, email)
VALUES (55560, 2990, 'John', 'Johnson', 'Stationsvej 9', 'Nivå', '+4512345678', 'John@kea.dk');
INSERT INTO Customer
(licenceNo, postalCode, givenname, lastname, address, city, contactNo, email)
VALUES (55578, 2400, 'Nanna', 'Mortensen', 'Emdrup Torv 10', 'Emdrup', '+4523456789', 'Nanna@kea.dk');
INSERT INTO Customer
(licenceNo, postalCode, givenname, lastname, address, city, contactNo, email)
VALUES (55578, 2400, 'Ludvig', 'Rasmussen', 'Emdrup Torv 10', 'Emdrup', '+4523456789', 'Ludvig@kea.dk');*/

/*Lease*/
/*INSERT INTO Lease
(durationMonths, dateOfRent, DateOfReturn, subscriptionType, CustomeridCustomer)
VALUES (5, '2022-12-04', '2022-12-05', 'LIMITED', '1');
INSERT INTO Lease
(durationMonths, dateOfRent, DateOfReturn, subscriptionType, CustomeridCustomer)
VALUES (12, '2022-12-05', '2022-12-06', 'UNLIMITED', '2');*/

/*CarTypeRef*/
INSERT INTO CarTypeRef
(seatingCapacity, taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth, brand, model,
 ´description´, transmissionType, fuelType)
VALUES (4, 146072, 36518, 18.5, 123, 3199, 'Citroën', 'C3 Le Mans 83 HK',
        'Citroën C3 skiller sig ud fra mængden med et markant og dristigt design. Og så er den særdeles rundhåndet med både plads og udstyr.

        Du får bl.a.Apple CarPlay, DAB-radio, 7" Touch Screen, som gør turen mere underholdende. På længere distancer vil du sætte pris på fartpilot og klimaanlæg, der sammen med de effektive LED-forlygter gør kørslen mindre stressende og sikrer et godt udsyn.',
        'MANUAL', 'GASOLINE');
INSERT INTO CarTypeRef
(seatingCapacity, taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth, brand, model,
 ´description´, transmissionType, fuelType)
VALUES (4, 207992, 51998, 311, 0, 3399, 'Fiat', '500e CABRIO Icon Pack 118 HK',
        'Fiat 500e CABRIO har en rækkevidde på hele 300 km. på en fuld opladning, og den vil bringe dig frem med stil som aldrig før.

        På bare 5 minutter kan du oplade bilen nok til at køre 50 Km.

        Fiat 500e CABRIO er det nyeste svar på en fantastisk bybil fra de italienske fabrikker. ',
        'AUTOMATIC', 'ELECTRIC');
INSERT INTO CarTypeRef
(seatingCapacity, taxableValue, registrationTax, fuelConsumption, emission, pricePerMonth, brand, model,
 ´description´, transmissionType, fuelType)
VALUES (4, 151992, 37998, 18.9, 125, 3799, 'Peugeot', '208 Active+ 100 HK',
        'Den helt nye modulplatform giver optimeret vejgreb, manøvredygtighed, støj- og varmekomfort, samt vægtreduktionen som medvirker til at begrænse CO2 udledningen og sikre dig en intens køreoplevelse.

        Udstyret med: LED kørelys, læderrat, 2-zoner klimaanlæg, fartpilot og Apple Carplay',
        'MANUAL', 'GASOLINE');

/*Car*/
/*INSERT INTO Car
(idCarVIN, isAvailable, initialKilometrage, regNo, LeaseidLease, CarTypeRefidCarTypeRef)
VALUES ('666666DK', 1, 1000, 'MINDYT69', 1, 1);
INSERT INTO Car
(idCarVIN, isAvailable, initialKilometrage, regNo, LeaseidLease, CarTypeRefidCarTypeRef)
VALUES ('888888DK', 0, 2000, 'MINKADET', 2, 2);*/

/*PickupLocationRef*/
INSERT INTO pickuplocationref
(address, city, postalCode)
VALUES ()

/*EquipmentRef*/

/*KilometragePlanRef*/



