/*
	Create drink tables, the main entity of database
*/
CREATE TABLE Drinks (
    id INT NOT NULL AUTO_INCREMENT,
	createdDate DATE NOT NULL,
    updatedDate DATE NOT NULL,
    name VARCHAR(255) NOT NULL,
	ingredients VARCHAR(255) NOT NULL,
	price DOUBLE NOT NULL,
	manufactureDate DATE NOT NULL,
    expirationDate DATE NOT NULL,
	id_category INT NOT NULL,
	id_manufacturer INT NOT NULL,
	id_supplier INT NOT NULL,
	CONSTRAINT PK_Drink PRIMARY KEY (id)
);

ALTER TABLE Drinks ADD FOREIGN KEY (id_category) REFERENCES Categories(id);
ALTER TABLE Drinks ADD FOREIGN KEY (id_manufacturer) REFERENCES Manufacturers(id);
ALTER TABLE Drinks ADD FOREIGN KEY (id_supplier) REFERENCES Suppliers(id);