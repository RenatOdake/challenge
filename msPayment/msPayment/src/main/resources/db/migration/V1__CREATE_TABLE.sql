CREATE TABLE IF NOT EXISTS payments(
    id SERIAL PRIMARY KEY,
    type varchar(255) NOT NULL,
    installments BOOLEAN,
    active BOOLEAN
);

CREATE TABLE installments(
    id SERIAL PRIMARY KEY,
    amount DECIMAL(10,2) NOT NULL,
    brand VARCHAR(30),
    paymentId SERIAL,
    FOREIGN KEY (paymentId) REFERENCES payments(id)
)