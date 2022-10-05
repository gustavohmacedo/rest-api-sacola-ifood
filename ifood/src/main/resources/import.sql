INSERT INTO tb_restaurant (restaurant_id, cep, complement, cnpj, name) VALUES (1, '04336-020', 'Próximo à praça da Sé', '61.564.376/0001-13', 'Restaurante & Pizzaria');
INSERT INTO tb_restaurant (restaurant_id, cep, complement, cnpj, name) VALUES (2, '12122-115', 'Em frente ao Batalhão', '68.024.293/0001-80', 'Restaurante Japonês');

INSERT INTO tb_client (client_id, cep, complement, name) VALUES (1, '33344-777', 'Apt. 126, Bloco B', 'Lucas Silva');
INSERT INTO tb_client (client_id, cep, complement, name) VALUES (2, '11122-999', 'Casa 02, Primeiro andar', 'João Silva');

INSERT INTO tb_product (product_id, is_available, name, product_value, restaurant_restaurant_id) VALUES (1, 1, 'Pizza', 45.0, 1);
INSERT INTO tb_product (product_id, is_available, name, product_value, restaurant_restaurant_id) VALUES (2, 1, 'Refrigerante', 4.5, 1);
INSERT INTO tb_product (product_id, is_available, name, product_value, restaurant_restaurant_id) VALUES (3, 1, 'Sorvete', 5.0, 2);

INSERT INTO tb_bag (bag_id, bag_total_amount, is_closed_bag, payment_type, client_client_id) VALUES (1, 0.0, 0, 0, 1);
INSERT INTO tb_bag (bag_id, bag_total_amount, is_closed_bag, payment_type, client_client_id) VALUES (2, 0.0, 0, 1, 2);

INSERT INTO tb_item (item_id, amount, bag_bag_id, product_product_id) VALUES (1, 1, 1, 1);
INSERT INTO tb_item (item_id, amount, bag_bag_id, product_product_id) VALUES (2, 1, 2, 2);

INSErT INTO tb_bag_bag_items (bag_bag_id , bag_items_item_id) VALUES (1, 1);
INSErT INTO tb_bag_bag_items (bag_bag_id , bag_items_item_id) VALUES (2, 2);

INSERT INTO tb_restaurant_menu (restaurant_restaurant_id, menu_product_id) values (1,1);
INSERT INTO tb_restaurant_menu (restaurant_restaurant_id, menu_product_id) values (2,2);

