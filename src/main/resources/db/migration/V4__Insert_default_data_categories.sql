/*
	Insert default data in Category table.
*/
INSERT INTO Categories(createdDate, updatedDate, name, description, alcoholic, maxPermanencyPeriod) VALUES
(now(), now(), 'Cerveja', 'O puro gosto da cevada!', true, 12),
(now(), now(), 'Refrigerante', 'Açúcar, muito açúcar pra alegar a vida!!!', false, 6),
(now(), now(), 'Vinho', 'Cheire, sinta e aprecie!', true, 36);