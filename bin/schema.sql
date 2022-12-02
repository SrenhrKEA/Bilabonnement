DROP DATABASE IF EXISTS bilabonnement;
CREATE DATABASE bilabonnement;
USE bilabonnement;

/*Static*/
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    username   varchar(50) UNIQUE                                   NOT NULL,
    ´password´ varchar(50)                                          NOT NULL,
    userType   ENUM ('DATA_REG', 'DAMAGE_REG', 'BUSINESS', 'ADMIN') NOT NULL,
    PRIMARY KEY (username)
);

DROP TABLE IF EXISTS kilometragePlan;
CREATE TABLE kilometragePlan
(
    idKilometragePlan int AUTO_INCREMENT,
    kilometrage       int    NOT NULL,
    pricePerMonth     double NOT NULL,
    PRIMARY KEY (idKilometragePlan)
);

DROP TABLE IF EXISTS equipment;
CREATE TABLE equipment
(
    idEquipment   int AUTO_INCREMENT,
    title         varchar(50)  NOT NULL,
    ´description´ varchar(250) NOT NULL,
    price         double       NOT NULL,
    PRIMARY KEY (idEquipment)
);

DROP TABLE IF EXISTS pickupLocation;
CREATE TABLE pickupLocation
(
    idPickupLocation int AUTO_INCREMENT,
    address          varchar(50) NOT NULL,
    city             varchar(50) NOT NULL,
    postalCode       int(4)      NOT NULL,
    PRIMARY KEY (idPickupLocation)
);

DROP TABLE IF EXISTS carType;
CREATE TABLE carType
(
    idCarType        int AUTO_INCREMENT,
    brand            varchar(50)  NOT NULL,
    model            varchar(50)  NOT NULL,
    color            varchar(25)  NOT NULL,
    type             varchar(25)  NOT NULL,
    ´description´    varchar(200) NOT NULL,
    seatingCapacity  int          NOT NULL,
    transmissionType int          NOT NULL,
    fuelType         int          NOT NULL,
    fuelConsumption  double       NOT NULL,
    emission         double       NOT NULL,
    taxableValue     double       NOT NULL,
    registrationTax  double       NOT NULL,
    PRIMARY KEY (idCarType)
);

/*Dynamic*/
DROP TABLE IF EXISTS customer;
CREATE TABLE customer
(
    idCustomer int AUTO_INCREMENT,
    licenceNo  int(8)       NOT NULL,
    givenname  varchar(50)  NOT NULL,
    lastname   varchar(50)  NOT NULL,
    address    varchar(50)  NOT NULL,
    city       varchar(50)  NOT NULL,
    postalCode int(4)       NOT NULL,
    contactNo  varchar(11)  NOT NULL,
    email      varchar(100) NOT NULL,
    PRIMARY KEY (idCustomer)
);

DROP TABLE IF EXISTS car;
CREATE TABLE car
(
    idCar              varchar(17) UNIQUE NOT NULL,
    regNo              varchar(7) UNIQUE  NOT NULL,
    initialKilometrage double             NOT NULL,
    available          boolean            NOT NULL,
    idCarType          int,
    PRIMARY KEY (idCar),
    FOREIGN KEY (idCarType) REFERENCES carType (idCarType)
);

DROP TABLE IF EXISTS damage;
CREATE TABLE damage
(
    idDamage      int AUTO_INCREMENT,
    title         varchar(50)  NOT NULL,
    ´description´ varchar(250) NOT NULL,
    price         double       NOT NULL,
    PRIMARY KEY (idDamage)
);

DROP TABLE IF EXISTS damageReport;
CREATE TABLE damageReport
(
    idDamageReport int AUTO_INCREMENT,
    dateOfDamage   date NOT NULL,
    idDamage       int,
    idCar          varchar(17),
    PRIMARY KEY (idDamageReport),
    FOREIGN KEY (idCar) REFERENCES car (idCar),
    FOREIGN KEY (idDamage) REFERENCES damage (idDamage)
);

DROP TABLE IF EXISTS optional;
CREATE TABLE optional
(
    idOptional        int AUTO_INCREMENT,
    idEquipment       int,
    idKilometragePlan int,
    PRIMARY KEY (idOptional),
    FOREIGN KEY (idEquipment) REFERENCES equipment (idEquipment),
    FOREIGN KEY (idKilometragePlan) REFERENCES kilometragePlan (idKilometragePlan)
);

DROP TABLE IF EXISTS lease;
CREATE TABLE lease
(
    idLease          int AUTO_INCREMENT,
    subscriptionType int  NOT NULL,
    durationMonths   int  NOT NULL,
    dateofRent       date NOT NULL,
    dateofReturn     date,
    idCar            varchar(17),
    idCustomer       int,
    idOptional       int,
    idPickupLocation int,
    PRIMARY KEY (idLease),
    FOREIGN KEY (idCar) REFERENCES car (idCar),
    FOREIGN KEY (idCustomer) REFERENCES customer (idCustomer),
    FOREIGN KEY (idOptional) REFERENCES optional (idOptional),
    FOREIGN KEY (idPickupLocation) REFERENCES pickupLocation (idPickupLocation)
);

