CREATE TABLE attribute_types (
    type_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE attribute_values (
    value_id SERIAL PRIMARY KEY,
    type_id BIGINT UNSIGNED NOT NULL ,
    value VARCHAR(100) NOT NULL,
    FOREIGN KEY (type_id) REFERENCES attribute_types(type_id) ON DELETE CASCADE
);

CREATE TABLE product_attributes (
    product_id BIGINT UNSIGNED,
    variant_id BIGINT UNSIGNED NULL,
    value_id BIGINT UNSIGNED,
    PRIMARY KEY (product_id, value_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (variant_id) REFERENCES variants(variant_id) ON DELETE CASCADE,
    FOREIGN KEY (value_id) REFERENCES attribute_values(value_id) ON DELETE CASCADE
);


drop table attribute_types,attribute_values ,product_attributes