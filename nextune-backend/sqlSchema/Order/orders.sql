CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    user_id BIGINT UNSIGNED,
    total DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'Pending',
    billing_address BIGINT UNSIGNED,
    shipping_address BIGINT UNSIGNED,
    
    FOREIGN KEY (billing_address) REFERENCES user_addresses(address_id) ON DELETE CASCADE,
    FOREIGN KEY (shipping_address) REFERENCES user_addresses(address_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE order_items (
    order_item_id SERIAL PRIMARY KEY,
    order_id BIGINT UNSIGNED,
    sku_id BIGINT UNSIGNED NOT NULL,
    quantity INT NOT NULL,
    price_at_purchase DECIMAL(10,2) NOT NULL,
    
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    
    FOREIGN KEY (sku_id) REFERENCES product_skus(sku_id) ON DELETE CASCADE
);

drop table order_items;