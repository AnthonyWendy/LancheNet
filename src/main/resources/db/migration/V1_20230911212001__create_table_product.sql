CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    nm_product VARCHAR(50) NOT NULL,
    price numeric(14, 2) NOT NULL,
    description varchar(50),
    active BOOLEAN NOT NULL
);