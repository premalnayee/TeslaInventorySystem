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
`PaymentMethod`)
VALUES
(1,
true,
"credit card");

INSERT INTO `teslainventory`.`products`
(`ProdName`,
`Colour`,
`BatterySize`,
`Autopilot`,
`DualMotor`,
`ReleaseDate`,
`ProductDelays`)
VALUES
("Model Y",
"Black",
"75KW",
true,
true,
"2020-03-13",
"");

SELECT * FROM teslainventory.products;
