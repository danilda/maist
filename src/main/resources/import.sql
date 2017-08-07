INSERT INTO user(id, login, password, email, active, first_name, last_name, phone, version) values (0,'admin', '$2a$10$UDvJMPOByqrkGi7Pk3gzBeS/2xgnAL3T/YNxhdbBOehmGJ.Jj4uGu', 'admin@mail.com', 1, 'Admin', 'Admin', '+380660000110', 1);
INSERT INTO user(id, login, password, email, active, first_name, last_name, phone, version) values (1, 'user', '$2a$10$jc4IZXkr3nrmbmQZNlVHpuaGdro/I4SjThww9BbGRk4PdHNOiUGvC', 'user@mail.com', 1, 'user', 'user', '+380660000111', 1);
INSERT INTO role VALUES (0 ,'ADMIN', 1);
INSERT INTO role VALUES (1 ,'USER', 1);
INSERT INTO AUTHORITIES values (0, 0);
INSERT INTO AUTHORITIES values (1, 1)
INSERT INTO orders(id, user_id, date, total_price) values (0, 1, CURRENT_TIME(), 669);
INSERT INTO orders(id, user_id, date, total_price) values (1, 1, CURRENT_TIME(), 667);
INSERT INTO item_type(id, parent_id, name) VALUES (0, null, 'item');
INSERT INTO item_type(id, parent_id, name) VALUES (1, 0, 'food');
INSERT INTO item_type(id, parent_id, name) VALUES (2, 0, 'household goods');
