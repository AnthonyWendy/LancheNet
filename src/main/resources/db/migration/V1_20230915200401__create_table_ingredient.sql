CREATE TABLE list_ingredient(
    id SERIAL PRIMARY KEY,
    ingredient_id bigserial NOT NULL,
    product_id bigserial NOT NULL,
    CONSTRAINT list_ingredient_fk_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredient(id),
    CONSTRAINT list_ingredient_fk_product_id FOREIGN KEY (product_id) REFERENCES ingredient(id)
);