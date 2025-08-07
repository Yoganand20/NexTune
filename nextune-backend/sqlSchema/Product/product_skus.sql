CREATE TABLE product_skus
(
    sku_id         SERIAL PRIMARY KEY,
    product_id     BIGINT UNSIGNED    NOT NULL,
    variant_id     BIGINT UNSIGNED    NOT NULL,
    sku_code       VARCHAR(50) UNIQUE NOT NULL,
    price          DECIMAL(10, 2)     NOT NULL,
    stock_quantity INT DEFAULT 0,
    weight_grams   INT,
    FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE,
    FOREIGN KEY (variant_id) REFERENCES variants (variant_id) ON DELETE CASCADE
);
