CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price numeric(14, 2) NOT NULL,
    description varchar(50),
    category_id int8 NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT product_fk_category_id FOREIGN KEY (category_id) REFERENCES category(id)
);