/*
	Create companies tables

	Supplier and Manufacturer are companies.
	That relationship will be mapped with the class per table, where Supplier and Manufacturer will be different tables.
*/
CREATE TABLE Manufacturer (
    id INT NOT NULL AUTO_INCREMENT,
	createdDate DATE NOT NULL,
    updatedDate DATE NOT NULL,
    name VARCHAR(255) NOT NULL,
	registry VARCHAR(255) NOT NULL,
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Manufacturer PRIMARY KEY (id)
);

CREATE TABLE Supplier (
    id INT NOT NULL AUTO_INCREMENT,
	createdDate DATE NOT NULL,
    updatedDate DATE NOT NULL,
    name VARCHAR(255) NOT NULL,
	registry VARCHAR(255) NOT NULL,
	phone VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Supplier PRIMARY KEY (id)
);