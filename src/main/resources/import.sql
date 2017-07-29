insert into users values (0, 1, 'admin@mail.com', 'admin', '$2a$10$UDvJMPOByqrkGi7Pk3gzBeS/2xgnAL3T/YNxhdbBOehmGJ.Jj4uGu',  1);
insert into users values (1, 1, 'user@mail.com', 'user', '$2a$10$jc4IZXkr3nrmbmQZNlVHpuaGdro/I4SjThww9BbGRk4PdHNOiUGvC',  1);
INSERT INTO roles VALUES (0 ,'ADMIN', 1);
INSERT INTO roles VALUES (1 ,'USER', 1);
insert into AUTHORITIES values (0, 0);
insert into AUTHORITIES values (1, 1);