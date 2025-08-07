CREATE TABLE products
(
    product_id  SERIAL PRIMARY KEY,
    category_id BIGINT UNSIGNED,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    brand       VARCHAR(100),
    FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE
);

CREATE TABLE inventory_movements
(
    id              SERIAL PRIMARY KEY,
    sku_id          BIGINT UNSIGNED                                            NOT NULL,
    movement_type   ENUM ('SALE', 'RESTOCK', 'ADJUSTMENT', 'RETURN', 'DAMAGE') NOT NULL,
    quantity_change INT                                                        NOT NULL, -- +10 for restock, -2 for sale
    quantity_before INT                                                        NOT NULL,
    quantity_after  INT                                                        NOT NULL,
    reference_id    BIGINT UNSIGNED,                                                     -- order_id for sales, etc.
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sku_id) REFERENCES product_skus (sku_id) ON DELETE CASCADE
);
