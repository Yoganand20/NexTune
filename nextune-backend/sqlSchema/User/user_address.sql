CREATE TABLE user_addresses
(
    address_id  SERIAL PRIMARY KEY,
    user_id     BIGINT UNSIGNED NOT NULL,
    full_name   VARCHAR(101) NOT NULL,
    email       VARCHAR(255),
    phone       VARCHAR(20),
    street      VARCHAR(255),
    city        VARCHAR(100),
    state       VARCHAR(50),
    postal_code VARCHAR(20),
    country     VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE SET NULL
);