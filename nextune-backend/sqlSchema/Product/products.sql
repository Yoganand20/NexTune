CREATE TABLE products (  
    product_id SERIAL PRIMARY KEY,  
    category_id BIGINT UNSIGNED,  
    name VARCHAR(255) NOT NULL,  
    description TEXT,  
    brand VARCHAR(100),
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE
);  