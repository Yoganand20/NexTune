CREATE TABLE attribute_types
(
    type_id SERIAL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL
);

CREATE TABLE attribute_values
(
    value_id SERIAL PRIMARY KEY,
    type_id  BIGINT UNSIGNED NOT NULL,
    value    VARCHAR(100)    NOT NULL,
    FOREIGN KEY (type_id) REFERENCES attribute_types (type_id) ON DELETE CASCADE
);

CREATE TABLE product_attributes
(
    variant_id   BIGINT UNSIGNED NOT NULL,
    attribute_id BIGINT UNSIGNED,
    PRIMARY KEY (variant_id, attribute_id),
    FOREIGN KEY (variant_id) REFERENCES variants (variant_id) ON DELETE CASCADE,
    FOREIGN KEY (attribute_id) REFERENCES attribute_values (value_id) ON DELETE CASCADE
);