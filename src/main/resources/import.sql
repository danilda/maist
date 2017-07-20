drop table users;
create table users (id integer, login varchar2(30), password varchar2(30), role varchar2(30), version integer);
insert into users values (0, 'admin', 'admin', 'admin', 1);