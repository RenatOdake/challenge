CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    sex VARCHAR(12) NOT NULL,
    birth_date DATE,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255),
    active BOOLEAN
);

CREATE TABLE IF NOT EXISTS address (
    id SERIAL PRIMARY KEY,
    state VARCHAR(40) NOT NULL,
    city VARCHAR(40) NOT NULL,
    district VARCHAR(40) NOT NULL,
    street varchar(40) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complement varchar(50),
    number int not null,
    customer_id INT,
    CONSTRAINT fk_address_customer FOREIGN KEY (customer_id) REFERENCES customer (id)
);