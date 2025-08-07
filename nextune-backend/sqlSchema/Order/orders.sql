CREATE TABLE orders
(
    order_id         SERIAL PRIMARY KEY,
    user_id          BIGINT UNSIGNED NOT NULL,
    total            DECIMAL(10, 2)  NOT NULL,
    status           VARCHAR(20)                                                DEFAULT 'Pending',
    billing_address  BIGINT UNSIGNED,
    shipping_address BIGINT UNSIGNED,
    created_at       TIMESTAMP                                                  DEFAULT CURRENT_TIMESTAMP,
    payment_type     ENUM ('COD', 'CREDIT_CARD', 'DEBIT_CARD', 'UPI', 'WALLET') DEFAULT 'COD',
    FOREIGN KEY (billing_address) REFERENCES user_addresses (address_id) ON DELETE SET NULL,
    FOREIGN KEY (shipping_address) REFERENCES user_addresses (address_id) ON DELETE SET NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE TABLE order_status_history
(
    id         SERIAL PRIMARY KEY,
    order_id   BIGINT UNSIGNED NOT NULL,
    status     VARCHAR(20)     NOT NULL,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by VARCHAR(100), -- 'system', admin user, etc.
    notes      TEXT,
    FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE
);

CREATE TABLE order_items
(
    order_item_id     SERIAL PRIMARY KEY,
    order_id          BIGINT UNSIGNED NOT NULL,
    sku_id            BIGINT UNSIGNED NOT NULL,
    quantity          INT             NOT NULL,
    price_at_purchase DECIMAL(10, 2)  NOT NULL,

    FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,

    FOREIGN KEY (sku_id) REFERENCES product_skus (sku_id) ON DELETE CASCADE
);