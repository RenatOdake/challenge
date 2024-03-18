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

CREATE TABLE IF NOT EXISTS estados(
    id SERIAL PRIMARY KEY,
    name varchar(50) NOT NULL,
    abbreviation varchar(2) NOT NULL
);


INSERT INTO estados (name, abbreviation) VALUES
('Acre', 'AC'),
('Alagoas', 'AL'),
('Amapá', 'AP'),
('Amazonas', 'AM'),
('Bahia', 'BA'),
('Ceará', 'CE'),
('Distrito Federal', 'DF'),
('Espírito Santo', 'ES'),
('Goiás', 'GO'),
('Maranhão', 'MA'),
('Mato Grosso', 'MT'),
('Mato Grosso do Sul', 'MS'),
('Minas Gerais', 'MG'),
('Pará', 'PA'),
('Paraíba', 'PB'),
('Paraná', 'PR'),
('Pernambuco', 'PE'),
('Piauí', 'PI'),
('Rio de Janeiro', 'RJ'),
('Rio Grande do Norte', 'RN'),
('Rio Grande do Sul', 'RS'),
('Rondônia', 'RO'),
('Roraima', 'RR'),
('Santa Catarina', 'SC'),
('São Paulo', 'SP'),
('Sergipe', 'SE'),
('Tocantins', 'TO');
