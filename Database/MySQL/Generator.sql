#create DATABASE TeslaInventory;
USE teslainventory;

# drop them tables

drop table if exists ProductOrderLookup;
drop table if exists Products;
drop table if exists Orders;
drop table IF EXISTS Customers;

CREATE TABLE Customers (
    CustID INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    Address VARCHAR(256),
    EmailAddress VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL,
    Age TINYINT NOT NULL,
    PRIMARY KEY (CustID)
);

CREATE TABLE Products (
    ProdID INT NOT NULL,
    ProdName VARCHAR(128) NOT NULL,
    Colour VARCHAR(32) NOT NULL,
    BatterySize VARCHAR(16) NOT NULL,
    Autopilot BOOLEAN NOT NULL,
    DualMotor BOOLEAN NOT NULL,
    ReleaseDate DATE,
    ProductDelays VARCHAR(32) NOT NULL,
    PRIMARY KEY (ProdID)
);

CREATE TABLE Orders (
    OrderID INT NOT NULL,
    CustID INT,
    Warranty BOOLEAN NOT NULL,
    PaymentMethod VARCHAR(32),
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustID)
        REFERENCES Customers (CustID)
);

CREATE TABLE ProductOrderLookup (
    ProdID INT NOT NULL,
    OrderID INT NOT NULL,
    FOREIGN KEY (ProdID)
        REFERENCES Products (ProdID),
    FOREIGN KEY (OrderID)
        REFERENCES Orders (OrderID),
    UNIQUE (ProdID , OrderID)
);