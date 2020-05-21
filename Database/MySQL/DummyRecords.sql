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
("Model Y",
"Black",
"75KW",
true,
true,
"2020-03-13",
"",
40000);

SELECT * FROM teslainventory.products;
