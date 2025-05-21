CREATE TABLE wishlists (  
    id SERIAL PRIMARY KEY,  
    user_id BIGINT UNSIGNED NOT NULL,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE  
);  


CREATE TABLE wishlist_items (  
    id SERIAL PRIMARY KEY,  
    wishlist_id BIGINT UNSIGNED NOT NULL,  
	product_id BIGINT UNSIGNED NOT NULL,
    variant_id BIGINT UNSIGNED NULL,  
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (wishlist_id) REFERENCES wishlists(id) ON DELETE CASCADE,  
    FOREIGN KEY (variant_id) REFERENCES variants(variant_id) ON DELETE CASCADE,  
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,  
    UNIQUE KEY unique_wishlist_variant (wishlist_id, variant_id)  
);