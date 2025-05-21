CREATE TABLE product_images (  
    image_id SERIAL PRIMARY KEY,  
    product_id BIGINT UNSIGNED NOT NULL, 
    variant_id BIGINT UNSIGNED NULL,  
    image_url TEXT NOT NULL,  
    sort_order INT DEFAULT 0,  
    alt_text VARCHAR(255),  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (variant_id) REFERENCES variants(variant_id) ON DELETE CASCADE  
);
