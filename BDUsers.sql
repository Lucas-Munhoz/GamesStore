use gamesstorebd;

CREATE USER 'gamesStoreApp'@'localhost' IDENTIFIED BY 'gs123';

GRANT gamesstore TO 'gamesStoreApp'@'localhost';
SET DEFAULT ROLE gamesstore TO gamesStoreApp@localhost;

CREATE USER 'admLucas'@'localhost' IDENTIFIED BY 'bd123';

GRANT adm TO 'admLucas'@'localhost';
SET DEFAULT ROLE adm TO admLucas@localhost;