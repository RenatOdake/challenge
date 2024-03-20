CREATE TABLE IF NOT EXISTS category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    active BOOLEAN,
    parent_id SERIAL,
    FOREIGN KEY (parent_id) REFERENCES category(id)
);



CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    material VARCHAR(20) NOT NULL,
    active BOOLEAN,
    category_id SERIAL,
    CONSTRAINT fk_productCategory FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS sku (
    id SERIAL PRIMARY KEY,
    price DECIMAL(10,2) NOT NULL,
    quantity int NOT NULL,
    color VARCHAR(40) NOT NULL,
    size varchar(40) NOT NULL,
    height DECIMAL(10,2) NOT NULL,
    width DECIMAL(10,2),
    product_id INT,
    CONSTRAINT fk_sku_product FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE IF NOT EXISTS media(
    id SERIAL PRIMARY KEY,
    IMAGE_URL varchar(1000)[],
    sku_id SERIAL,
    CONSTRAINT fk_mediaSku FOREIGN KEY (sku_id) REFERENCES sku (id)
);

