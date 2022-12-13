/*User*/
INSERT INTO user (username, ´password´, userType)
VALUES ('ADMIN', 'ADMIN', 'ADMIN');
INSERT INTO user (username, ´password´, userType)
VALUES ('John', '123', 'DAMAGE_REG');
INSERT INTO user (username, ´password´, userType)
VALUES ('Jesus', '123', 'DATA_REG');
INSERT INTO user (username, ´password´, userType)
VALUES ('Bob', '123', 'BUSINESS');

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


/*PickupLocationRef*/
INSERT INTO pickuplocationref
(title, address, city, postalCode)
VALUES ('Bilsalg Ballerup','Industriparken 34','Ballerup',2750);

INSERT INTO pickuplocationref
(title, address, city, postalCode)
VALUES ('FDM: Bilsyn i Taastrup','Mårkærvej 4','Taastrup',2630);

INSERT INTO pickuplocationref
(title, address, city, postalCode)
VALUES ('FDM: Bilsyn på Amager','Løjtegårdsvej 153','Kastrup, Tårnby',2770);

/*EquipmentRef*/
/*INSERT INTO equipmentref (title, ´description´, price, CarTypeRefidCarTypeRef)
VALUES ()*/


/*KilometragePlanRef*/
INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (250,300);

INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (500,590);

INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (1000,1160);

INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (1500,1719);

INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (2000,2240);

INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (2500,2750);

INSERT INTO kilometrageplanref (kilometrage, pricePerMonth)
VALUES (3000,3240);



