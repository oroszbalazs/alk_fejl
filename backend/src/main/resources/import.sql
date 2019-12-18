INSERT INTO USER (user_id, name, user_name, password, role) VALUES (1, 'admin', 'admin' , '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'ROLE_ADMIN');
INSERT INTO USER (user_id, name, user_name, password, role) VALUES (2, 'user', 'user' , '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'ROLE_USER');
INSERT INTO PRODUCT (product_id, in_stock, name, price) VALUES (1, true, 'apple', 500);
INSERT INTO PRODUCT (product_id, in_stock, name, price) VALUES (2, true, 'orange', 600);
INSERT INTO ORDER_TABLE (order_id, status) VALUES (1, 'STATUS_REJECTED');
INSERT INTO ORDER_USER (order_id, user_id) VALUES (1, 1);

--INSERT INTO BASKET (basket_id, user_id) VALUES (1, 1);
--INSERT INTO BASKET (basket_id, user_id) VALUES (2, 2);
--INSERT INTO BASKET_PRODUCT (basket_id, product_id) VALUES (1, 1);
--INSERT INTO BASKET_PRODUCT (basket_id, product_id) VALUES (1, 2);
--INSERT INTO BASKET_PRODUCT (basket_id, product_id) VALUES (2, 1);
--INSERT INTO BASKET_PRODUCT (basket_id, product_id) VALUES (2, 2);