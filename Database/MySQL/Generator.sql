create DATABASE TeslaInventory;
USE TeslaInventory;

# drop them tables
drop table if exists ProductOrderAdjudicator;
drop table if exists Products;
drop table if exists Orders;
drop table IF EXISTS Customers;

# Create customers table
CREATE TABLE Customers (
    CustID int NOT NULL,
    FirstName varchar(100) NOT NULL,
    LastName varchar(100) NOT NULL,
    Address varchar(256),
    EmailAddress varchar(100) NOT NULL,
    PhoneNumber varchar(20) NOT NULL,
    Age TINYINT NOT NULL,
    PRIMARY KEY (CustID)
); 

# Create Products table
CREATE TABLE Products (
    ProdID int NOT NULL,
    ProdName VARCHAR(128) NOT NULL,
    Colour VARCHAR(32) NOT NULL,
    BatterySize VARCHAR(16) NOT NULL,
    Autopilot boolean NOT NULL,
	DualMotor boolean NOT NULL,
    ReleaseDate DATE,
    ProductDelays VARCHAR(32) NOT NULL,
    PRIMARY KEY (ProdID)
); 

# Create customers Orders
CREATE TABLE Orders (
    OrderID INT NOT NULL,
    CustID INT,
    Warranty BOOLEAN NOT NULL,
    PaymentMethod VARCHAR(32),
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustID)
		REFERENCES Customers (CustID)
); 

# Create ProductOrdersLookup table to represent the many to many relationship between products and orders
CREATE TABLE ProductOrderLookup (
	ProdID int NOT NULL,
    OrderID int NOT NULL,
    FOREIGN KEY (ProdID) REFERENCES Products(ProdID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    UNIQUE(ProdID, OrderID)
);