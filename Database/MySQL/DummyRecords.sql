USE teslainventory;

SELECT `customers`.`CustID`,
    `customers`.`FirstName`,
    `customers`.`LastName`,
    `customers`.`Address`,
    `customers`.`EmailAddress`,
    `customers`.`PhoneNumber`,
    `customers`.`Age`
FROM `teslainventory`.`customers`;

SELECT * FROM Orders;
SELECT * FROM Customers;
SELECT * FROM ProductOrderLookup;

SELECT CustID FROM Customers 
WHERE FirstName = "John" AND LastName = "Gerry";

INSERT INTO Customers (
    `customers`.`FirstName`,
    `customers`.`LastName`,
    `customers`.`Address`,
    `customers`.`EmailAddress`,
    `customers`.`PhoneNumber`,
    `customers`.`Age`)
VALUES ('John', 'Gerry', '10 fdsfds', 'fdsfsd@gfadsf.com', '+1334324253543','12');

INSERT INTO `teslainventory`.`orders`
(`CustID`,
`Warranty`,
`PaymentMethod`,
`Total`)
VALUES
(1,
true,
"credit card",
40000);

INSERT INTO `teslainventory`.`products`
(`ProdName`,
`Colour`,
`BatterySize`,
`Autopilot`,
`DualMotor`,
`ReleaseDate`,
`ProductDelays`,
`Price`)
VALUES
("Model X",
"Space Grey",
"75 KW",
true,
true,
"2015-09-29",
"6 months",
60000);

INSERT INTO `teslainventory`.`products`
(`ProdName`,
`Colour`,
`BatterySize`,
`Autopilot`,
`DualMotor`,
`ReleaseDate`,
`ProductDelays`,
`Price`)
VALUES
("Model Y",
"Black",
"75KW",
true,
true,
"2020-03-13",
"",
40000);

INSERT INTO `teslainventory`.`products`
(`ProdName`,
`Colour`,
`BatterySize`,
`Autopilot`,
`DualMotor`,
`ReleaseDate`,
`ProductDelays`,
`Price`)
VALUES
("Model 3",
"Black",
"75KW",
true,
true,
"2019-03-13",
"",
30000);

INSERT INTO `teslainventory`.`productorderlookup`
(`ProdID`,
`OrderID`)
VALUES
(1,
1);

