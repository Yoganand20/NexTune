CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    parent_category_id BIGINT UNSIGNED NULL,
    description TEXT,
    FOREIGN KEY (parent_category_id) REFERENCES categories(category_id)
);