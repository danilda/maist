--DROP TABLE IF EXISTS authorities;
CREATE CACHED TABLE PUBLIC.AUTHORITIES( USER_ID BIGINT NOT NULL, ROLE_ID INTEGER NOT NULL );
--DROP TABLE IF EXISTS persistent_logins;
CREATE TABLE persistent_logins (
  user_id int PRIMARY KEY,
  series varchar(64) NOT NULL,
  token varchar(64) NOT NULL,
  last_used Date NOT NULL);
--DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id int PRIMARY KEY,
  login varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  active int NOT NULL,
  version int NOT NULL
);
--DROP TABLE IF EXISTS roles/
CREATE TABLE roles (
  role_id int PRIMARY KEY,
  role varchar(45) NOT NULL,
  version int NOT NULL
);
--INSERT INTO `role` VALUES (1,'R_ADMIN', 1);