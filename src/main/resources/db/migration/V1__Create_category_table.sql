/*
	Create category table
*/
CREATE TABLE Categories (
    id INT NOT NULL AUTO_INCREMENT,
	createdDate DATE NOT NULL,
    updatedDate DATE NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    alcoholic BOOLEAN NOT NULL,
    maxPermanencyPeriod INT NOT NULL,
	CONSTRAINT PK_Category PRIMARY KEY (id)
);