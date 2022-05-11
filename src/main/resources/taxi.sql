Use taxi_shcherbina;
INSERT INTO CarTypes (name)
VALUES ('Premium'),
	   ('Regular');

INSERT INTO Cars (number, car_type_id)
VALUE ('454223', '2'),
	  ('236732', '1'),
	  ('954325', '2');
SELECT * from Cars;

INSERT INTO Autoservices (name)
VALUE ('BMW'),
	  ('Audi'),
      ('Lexus');
SELECT * from Autoservices;

INSERT INTO CarOrders (car_id, autoservice_id, total)
VALUE ('2', '2', '200'),
 ('1', '1', '400'),
 ('3', '3', '300');
SELECT * from CarOrders;

INSERT INTO CustomerTypes (name, discount)
VALUES ('regular', '10'),
('friend', '20'),
('regular', '0');
SELECT * from CustomerTypes;

INSERT INTO Customers (f_name, l_name, rating, email, CustomerTypes)
VALUES ('Hope', 'Mcnally', '5', 'hopemc@gmail.com', '2'),
	   ('Bryan', 'Hibbert', '4', 'bryanhib@gmail.com', '1'),
	   ('Avaya', 'Wong', '4', 'wongava@gmail.com', '3');
SELECT * from Customers;

INSERT INTO CallOperators (f_name, l_name)
VALUES ( 'Ruth', 'Tapia'),
	   ('Reilly', 'York'),
       ('3', 'Lainey', 'Clayton');
SELECT * from CallOperators;

INSERT INTO Cities (name)
VALUES  ('New York'),
		('Chicago'),
		('Boston');

INSERT INTO Address (zip, cities_id)
VALUES  ('10001', '1'),
		('60007', '2'),
        ('02108', '3');
SELECT * from Address;

INSERT INTO Drivers (f_name, date_of_start)
VALUES 	('Jordon', '2021-02-08'),
		('Watts', '2021-12-10'),
		('Duke', '2022-01-03');
SELECT * from Drivers;

INSERT INTO License (number, exp_day, driver_id)
VALUES ('AA122345', '2020-8-3', '1'),
	   ( 'AX567345', '2021-12-24', '2'),
	   ('AK345455', '2021-1-8', '3');

INSERT INTO Orders (time, customer_id, car_id, driver_id, from_id, to_id, total, operators_id)
VALUES ('10-05-01', '1', '2', '1', '1', '2', '25', '1'),
	   ('09-05-01', '2', '1', '2', '2', '1', '15', '2'),
	   ('07-10-01', '3', '3', '3', '1', '2', '30', '3');
SELECT * from Orders;

-- Update --
UPDATE CustomerTypes
SET discount = '0'
WHERE id = '1';
SELECT * from CustomerTypes;
UPDATE Orders
SET time = '22-05-01  10:15:00'
WHERE customer_id = 1;
UPDATE Orders
SET time = '22-05-01  12:10:00'
WHERE customer_id = 2;
UPDATE Orders
SET time = '22-05-01  17:20:00'
WHERE customer_id = 3;
SELECT * from Orders;

-- Delete --
DELETE FROM License WHERE driver_id = 3;
SELECT * from License;
DELETE FROM CarOrders WHERE car_id = '2';
DELETE FROM CarTypes WHERE id = '7';
DELETE FROM Cars WHERE id = '6';
DELETE FROM CarOrders WHERE id = '5';

-- Select --
SELECT * FROM Orders
WHERE total ='25' AND car_id = 2;
SELECT * FROM Cities
WHERE name IN ('New York', 'Chicago', 'Boston');
SELECT * FROM CarOrders
WHERE total BETWEEN 100 AND 300;
SELECT * FROM Cities
ORDER BY name;
SELECT * FROM Customers
WHERE rating='4' OR email='wongava@gmail.com';

-- Join --
SELECT Customers.f_name, Orders.time, Orders.total
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id ;

SELECT Customers.l_name, Orders.id
FROM Customers
LEFT JOIN Orders ON Customers.id = Orders.customer_id
ORDER BY Customers.l_name;

SELECT Orders.id, Drivers.f_name, Drivers.date_of_start
FROM Orders
RIGHT JOIN Drivers ON Orders.driver_id = Drivers.id
ORDER BY Orders.id;
