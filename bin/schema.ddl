CREATE TABLE Car
(
    idCarVIN               varchar(255) NOT NULL,
    isAvailable            boolean      NOT NULL,
    initialKilometrage     double       NOT NULL,
    regNo                  varchar(255) NOT NULL,
    CarTypeRefidCarTypeRef int(10)      NOT NULL,
    PRIMARY KEY (idCarVIN)
);
CREATE TABLE CarTypeRef
(
    idCarTypeRef     int(10)                                 NOT NULL AUTO_INCREMENT,
    seatingCapacity  int(10)                                 NOT NULL,
    taxableValue     double                                  NOT NULL,
    registrationTax  double                                  NOT NULL,
    fuelConsumption  double                                  NOT NULL,
    emission         double                                  NOT NULL,
    pricePerMonth    double                                  NOT NULL,
    brand            varchar(255)                            NOT NULL,
    model            varchar(255)                            NOT NULL,
    ´description´    varchar(2550)                           ,
    transmissionType ENUM ('MANUAL', 'AUTOMATIC')            NOT NULL,
    fuelType         ENUM ('GASOLINE', 'DIESEL', 'ELECTRIC') NOT NULL,
    PRIMARY KEY (idCarTypeRef)
);
CREATE TABLE Customer
(
    idCustomer  int(10)      NOT NULL AUTO_INCREMENT,
    licenceNo   varchar(255) NOT NULL UNIQUE,
    postalCode  int(10)      NOT NULL,
    firstName   varchar(255) NOT NULL,
    lastName    varchar(255) NOT NULL,
    address     varchar(255) NOT NULL,
    city        varchar(255) NOT NULL,
    contactNo   varchar(255) NOT NULL,
    email       varchar(255) NOT NULL,
    nationality varchar(255) NOT NULL,
    PRIMARY KEY (idCustomer)
);
CREATE TABLE Damage
(
    idDamage                   int(10)      NOT NULL AUTO_INCREMENT,
    title                      varchar(255) NOT NULL,
    ´description´              varchar(2550),
    price                      double       NOT NULL,
    DamageReportidDamageReport int(10)      NOT NULL,
    PRIMARY KEY (idDamage)
);
CREATE TABLE DamageReport
(
    idDamageReport int(10)      NOT NULL AUTO_INCREMENT,
    dateOfReport   date         NOT NULL,
    CaridCarVIN    varchar(255) NOT NULL,
    PRIMARY KEY (idDamageReport)
);
CREATE TABLE Equipment
(
    idEquipment                int(10) NOT NULL AUTO_INCREMENT,
    LeaseidLease               int(10) NOT NULL,
    EquipmentRefidEquipmentRef int(10) NOT NULL,
    PRIMARY KEY (idEquipment)
);
CREATE TABLE EquipmentRef
(
    idEquipmentRef         int(10)       NOT NULL AUTO_INCREMENT,
    title                  varchar(255)  NOT NULL,
    ´description´          varchar(2550) ,
    price                  double NOT NULL,
    CarTypeRefidCarTypeRef int(10)       NOT NULL,
    PRIMARY KEY (idEquipmentRef)
);
CREATE TABLE KilometragePlan
(
    idKilometragePlan                      int(10) NOT NULL AUTO_INCREMENT,
    LeaseidLease                           int(10) NOT NULL UNIQUE ,
    KilometragePlanRefidKilometragePlanRef int(10) NOT NULL,
    PRIMARY KEY (idKilometragePlan)
);
CREATE TABLE KilometragePlanRef
(
    idKilometragePlanRef int(10) NOT NULL AUTO_INCREMENT,
    kilometrage          double  NOT NULL,
    pricePerMonth        int(10) NOT NULL,
    PRIMARY KEY (idKilometragePlanRef)
);
CREATE TABLE Lease
(
    idLease            int(10)                       NOT NULL AUTO_INCREMENT,
    durationMonths     int(10)                       NOT NULL,
    dateOfRent         date                          NOT NULL,
    dateOfReturn       date                          NOT NULL,
    subscriptionType   ENUM ('LIMITED', 'UNLIMITED') NOT NULL,
    CustomeridCustomer int(10)                       NOT NULL,
    CaridCarVIN        varchar(255)                  NOT NULL,
    PRIMARY KEY (idLease)
);
CREATE TABLE PickupLocation
(
    idPickupLocation                     int(10) NOT NULL AUTO_INCREMENT,
    LeaseidLease                         int(10) NOT NULL UNIQUE ,
    PickupLocationRefidPickupLocationRef int(10) NOT NULL,
    PRIMARY KEY (idPickupLocation)
);
CREATE TABLE PickupLocationRef
(
    idPickupLocationRef int(10)      NOT NULL AUTO_INCREMENT,
    address             varchar(255) NOT NULL,
    city                varchar(255) NOT NULL,
    postalCode          int(10)      NOT NULL,
    title               varchar(255) NOT NULL,
    PRIMARY KEY (idPickupLocationRef)
);
CREATE TABLE `User`
(
    username   varchar(255)                                         NOT NULL,
    ´password´ varchar(255)                                         NOT NULL,
    userType   ENUM ('DATA_REG', 'DAMAGE_REG', 'BUSINESS', 'ADMIN') NOT NULL,
    PRIMARY KEY (username)
);
ALTER TABLE Lease
    ADD CONSTRAINT FKLease876541 FOREIGN KEY (CaridCarVIN) REFERENCES Car (idCarVIN);
ALTER TABLE EquipmentRef
    ADD CONSTRAINT FKEquipmentR218579 FOREIGN KEY (CarTypeRefidCarTypeRef) REFERENCES CarTypeRef (idCarTypeRef);
ALTER TABLE Car
    ADD CONSTRAINT FKCar966112 FOREIGN KEY (CarTypeRefidCarTypeRef) REFERENCES CarTypeRef (idCarTypeRef);
ALTER TABLE PickupLocation
    ADD CONSTRAINT FKPickupLoca717196 FOREIGN KEY (PickupLocationRefidPickupLocationRef) REFERENCES PickupLocationRef (idPickupLocationRef);
ALTER TABLE Equipment
    ADD CONSTRAINT FKEquipment456582 FOREIGN KEY (EquipmentRefidEquipmentRef) REFERENCES EquipmentRef (idEquipmentRef);
ALTER TABLE Equipment
    ADD CONSTRAINT FKEquipment419857 FOREIGN KEY (LeaseidLease) REFERENCES Lease (idLease);
ALTER TABLE KilometragePlan
    ADD CONSTRAINT FKKilometrag832788 FOREIGN KEY (KilometragePlanRefidKilometragePlanRef) REFERENCES KilometragePlanRef (idKilometragePlanRef);
ALTER TABLE KilometragePlan
    ADD CONSTRAINT FKKilometrag584886 FOREIGN KEY (LeaseidLease) REFERENCES Lease (idLease);
ALTER TABLE PickupLocation
    ADD CONSTRAINT FKPickupLoca279153 FOREIGN KEY (LeaseidLease) REFERENCES Lease (idLease);
ALTER TABLE DamageReport
    ADD CONSTRAINT FKDamageRepo166854 FOREIGN KEY (CaridCarVIN) REFERENCES Car (idCarVIN);
ALTER TABLE Damage
    ADD CONSTRAINT FKDamage718366 FOREIGN KEY (DamageReportidDamageReport) REFERENCES DamageReport (idDamageReport);
ALTER TABLE Lease
    ADD CONSTRAINT FKLease644241 FOREIGN KEY (CustomeridCustomer) REFERENCES Customer (idCustomer);

