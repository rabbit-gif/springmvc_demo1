-- Customer table
CREATE TABLE IF NOT EXISTS customer (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    phone       VARCHAR(20),
    email       VARCHAR(100),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Address table
CREATE TABLE IF NOT EXISTS address (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id   BIGINT NOT NULL,
    province      VARCHAR(50),
    city          VARCHAR(50),
    district      VARCHAR(50),
    detail        VARCHAR(200),
    postal_code   VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- ProductItem table
CREATE TABLE IF NOT EXISTS product_item (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name  VARCHAR(200) NOT NULL,
    product_code  VARCHAR(50),
    price         DECIMAL(10, 2),
    stock         INT DEFAULT 0,
    category      VARCHAR(100)
);

-- Order table
CREATE TABLE IF NOT EXISTS t_order (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id     BIGINT NOT NULL,
    customer_name   VARCHAR(100) NOT NULL,
    product_item    VARCHAR(200) NOT NULL,
    address         VARCHAR(500),
    amount          DECIMAL(12, 2),
    order_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
