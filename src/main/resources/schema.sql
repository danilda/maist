CREATE CACHED TABLE PUBLIC.AUTHORITIES ( USER_ID BIGINT NOT NULL, ROLE_ID INTEGER NOT NULL );
CREATE TABLE persistent_login (
  id int PRIMARY KEY,
  series varchar(64) NOT NULL,
  token varchar(64) NOT NULL,
  last_used Date NOT NULL);
CREATE TABLE user (
  id int PRIMARY KEY,
  login varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  active int NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  phone VARCHAR(20),
  version int NOT NULL
);
CREATE TABLE role (
  id int PRIMARY KEY,
  role varchar(45) NOT NULL,
  version int NOT NULL
);
CREATE TABLE orders (
  id int PRIMARY KEY,
  user_id int NOT NULL,
  date DATE NOT NULL,
  total_price NUMBER(12,2)
);
CREATE TABLE order_item (
  order_id int NOT NULL UNIQUE,
  item_id int NOT NULL UNIQUE,
  count int NOT NULL
);
CREATE TABLE item_type (
  id int PRIMARY KEY,
  parent_id int NOT NULL,
  name VARCHAR NOT NULL
);
CREATE TABLE item (
  id int PRIMARY KEY,
  item_type_id int NOT NULL UNIQUE,
  name VARCHAR NOT NULL,
  cost NUMBER(12,2) NOT NULL,
  count int NOT NULL,
  description VARCHAR
);
CREATE TABLE item_attribute (
  id int PRIMARY KEY,
  item_type_id int NOT NULL,
  name VARCHAR NOT NULL
);
CREATE TABLE item_property (
  id int PRIMARY KEY,
  item_id int NOT NULL,
  attr_id int NOT NULL,
  value VARCHAR
);