CREATE TABLE variants
(
    variant_id SERIAL PRIMARY KEY,
    product_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE
);