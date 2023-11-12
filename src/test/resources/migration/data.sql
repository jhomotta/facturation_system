-- products
INSERT INTO products (name, price) VALUES ('Martillo', 15.99);
INSERT INTO products (name, price) VALUES ('Tornillos', 5.49);
INSERT INTO products (name, price) VALUES ('Sierra', 20.89);
-- sellers
INSERT INTO sellers (name) VALUES ('Juan Pérez');
INSERT INTO sellers (name) VALUES ('Ana Gómez');
INSERT INTO sellers (name) VALUES ('Luis Ramírez');

-- sales
INSERT INTO sales (seller_id, created_date, last_modified_date) VALUES (1, '2021-01-01 08:00:00', '2021-01-01 08:00:00');
INSERT INTO sales (seller_id, created_date, last_modified_date) VALUES (2, '2021-01-02 09:30:00', '2021-01-02 09:30:00');

-- sale_details
INSERT INTO sale_details (sale_id, product_id, quantity, price) VALUES (1, 1, 3, 15.99);
INSERT INTO sale_details (sale_id, product_id, quantity, price) VALUES (1, 2, 50, 5.49);
INSERT INTO sale_details (sale_id, product_id, quantity, price) VALUES (2, 3, 2, 20.89);

-- inventory
INSERT INTO inventory (product_id, quantity) VALUES (1, 100);
INSERT INTO inventory (product_id, quantity) VALUES (2, 200);
INSERT INTO inventory (product_id, quantity) VALUES (3, 150);