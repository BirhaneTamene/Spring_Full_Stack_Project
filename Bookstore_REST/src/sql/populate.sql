 
INSERT INTO credentials(username,password,enabled) VALUES ('Sean','$2y$12$efinKpsW9QTajzCDGyHXZ.bnn5.fE6cPqzqat949jxXcqS4PnjJeC', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('Bill','$2y$12$5cxr5CpzBWSUqynxuiUPSOYcl0HdTqRWbF8EJe27vnMGmEsbvlsIe', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('Pete','$2y$12$wb.rdqzUSpMrbYjhdMzlLOG71yHjepQa2W7PQG4zuEHz8QTmzOvtO', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('Bire','$2y$12$dlSacbd.noHOpcgtWm4CmOswoffQ8XPowRlcSaLDV3aZu7aqh92ny', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('Ujjwol','$2y$12$ZlsHUvFaZu.QoyWwqmndwO4TPfzBuuyjQNGOt89jfAA4z7ZfTAhri', TRUE);
 
INSERT INTO authority (id, authority) VALUES (1,'ROLE_USER');
INSERT INTO authority (id, authority) VALUES (2,'ROLE_ADMIN');

INSERT INTO `GroupsToo` (id,group_name) VALUES (1, 'USER');
INSERT INTO `GroupsToo` (id,group_name) VALUES (2, 'ADMIN');

INSERT INTO `GroupsToo_Authority` VALUES (1, 1);
INSERT INTO `GroupsToo_Authority` VALUES (2, 2);

INSERT INTO `GroupsToo_Credentials` VALUES (2, 'Bill');
INSERT INTO `GroupsToo_Credentials` VALUES (2, 'Bire');
INSERT INTO `GroupsToo_Credentials` VALUES (1, 'Sean');
INSERT INTO `GroupsToo_Credentials` VALUES (1, 'Pete');
INSERT INTO `GroupsToo_Credentials` VALUES (1, 'Ujjwol');

INSERT INTO  `Customer` (firstname, lastname, email, phone, credential_id) VALUES ('Sean','Smith', 'sean@gmail.com', '1234','Sean');
INSERT INTO `Customer` (firstname, lastname, email, phone, credential_id) VALUES ('Bill','Due', 'bill@gmail.com','2345','Bill');
INSERT INTO  `Customer` (firstname, lastname, email, phone, credential_id) VALUES ('Pete','Moss', 'pete@gmail.com', '3454','Pete');
INSERT INTO `Customer` (firstname, lastname, email, phone, credential_id) VALUES ('Bire','Tamene', 'bire@gmail.com','4512','Bire');
INSERT INTO  `Customer` (firstname, lastname, email, phone, credential_id) VALUES ('Ujjwol','Bhandari', 'ujjwol@gmail.com', '2374','Ujjwol');

INSERT INTO `ADDRESS` (id,city,state,street,customer_id) VALUES (1,'Batavia','Iowa','Main','1');
INSERT INTO `ADDRESS` (id,city,state,street,customer_id) VALUES (2,'Red Rock','Iowa','Main','1');
INSERT INTO `ADDRESS` (id,city,state,street,customer_id) VALUES (3,'Washington','Iowa','Maple','2');
INSERT INTO `ADDRESS` (id,city,state,street,customer_id) VALUES (4,'Mexico','Iowa','Maple','2');

INSERT INTO product(id,name,price, description) VALUES (1,"Intro to EA",22.0, "Spring, AOP, Hibernate, REST... ");
INSERT INTO product(id,name,price, description) VALUES (2,"Intro to Hibernate",22.0, "Hibernate... ");

INSERT INTO orders(Order_ID, Customer_ID) VALUES (1, 2);
INSERT INTO orders(Order_ID, Customer_ID) VALUES (2, 1);

INSERT INTO Order_Product VALUES (1, 1);
INSERT INTO Order_Product VALUES (2, 2);
 
					