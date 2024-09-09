CREATE TABLE client
(
    client_id   UUID PRIMARY KEY,
    nit          VARCHAR(15)  NOT NULL,
    birth_date     DATE,
    full_name     VARCHAR(150) NOT NULL,
    email        VARCHAR(150) NOT NULL UNIQUE,
    phone_number VARCHAR(15),
    UNIQUE (nit),
    UNIQUE (email)
);