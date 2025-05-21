CREATE TABLE users (  
    user_id SERIAL PRIMARY KEY,  
    first_name VARCHAR(50) NOT NULL,  
    last_name VARCHAR(50) NOT NULL,  
    email VARCHAR(255) UNIQUE NOT NULL,  
    password_hash CHAR(60) NOT NULL,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
	last_modified_at TIMESTAMP,
    last_login DATETIME  
);
