BEGIN TRANSACTION;

DROP TABLE IF EXISTS subscriber;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE subscriber (
  hex_id uuid DEFAULT uuid_generate_v4 (),
  first_name varchar(64) NOT NULL,     
  last_name varchar(64),
  email varchar(64) NOT NULL,
  phone_number varchar(64),
  PRIMARY KEY (hex_id)
);

COMMIT TRANSACTION;
