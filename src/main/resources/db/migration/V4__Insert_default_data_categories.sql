/*
	Insert default data in Category table.
*/
INSERT INTO Categories(createdDate, updatedDate, name, description, alcoholic, maxPermanencyPeriod) VALUES
(now(), now(), 'Cerveja', 'O puro gosto da cevada!', true, parsedatetime('01-09-2018 00:00:00.0', 'dd-MM-yyyy hh:mm:ss.SS')),
(now(), now(), 'Refrigerante', 'Açúcar, muito açúcar pra alegar a vida!!!', false, parsedatetime('01-12-2017 00:00:00.0', 'dd-MM-yyyy hh:mm:ss.SS')),
(now(), now(), 'Vinho', 'Cheire, sinta e aprecie!', true, parsedatetime('01-01-2020 00:00:00.0', 'dd-MM-yyyy hh:mm:ss.SS'));