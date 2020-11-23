create database MarioPizza;
create table Pizza(
pizzaID int not null auto_increment primary key,
price int not null,
title varchar(255) not null,
topping varchar(255) not null
);

INSERT INTO Pizza (price,title,topping) VALUES (57,"Vesuvio","tomatsauce, ost, skinke og oregano"),
(53,"Amerikaner","tomatsauce, ost, oksefars og oregano"),
(57,"Cacciatore","tomatsauce, ost, pepperoni og oregano"),
(63,"Carbona","tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano"),
(63,"Dennis","tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano"),
(63,"Bertil","tomatsauce, ost, bacon og oregano"),
(61,"Silvia","tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano"),
(61,"Victoria","tomatsauce, ost, skinke, ananas, champignon, løg og oregano"),
(61,"Toronfo","tomatsauce, ost, skinke, bacon, kebab, chili og oregano"),
(61,"Capricciosa","tomatsauce, ost, skinke, champignon og oregano"),
(61,"Hawaii","tomatsauce, ost, skinke, ananas og oregano"),
(69,"Rasmus","gorgonzola, parmesan, gedeost og mozzarella");

SELECT * FROM Pizza;
create table CompletedOrder (
currentTime varchar(255) not null,
orderID int not null auto_increment primary key,
phone varchar(255) not null,
pizzas varchar(255) not null,
price int not null
);

INSERT INTO CompletedOrder (currentTime,orderID,phone,pizzas,price) VALUES (?,?,?,?,?);

SELECT * FROM CompletedOrder;
