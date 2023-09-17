CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(25) NOT NULL,
    type_user VARCHAR(15),
    password VARCHAR(200) NOT NULL,
    active BOOLEAN NOT NULL
);