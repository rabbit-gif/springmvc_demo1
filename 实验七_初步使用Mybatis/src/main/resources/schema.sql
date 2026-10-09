CREATE TABLE IF NOT EXISTS users (
    user_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50),
    password  VARCHAR(100),
    email     VARCHAR(100),
    birth_date DATE
);
