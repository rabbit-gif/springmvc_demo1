-- Seed data for Customer
INSERT INTO customer (name, phone, email) VALUES ('Zhang San', '13800001111', 'zhangsan@example.com');
INSERT INTO customer (name, phone, email) VALUES ('Li Si',    '13800002222', 'lisi@example.com');
INSERT INTO customer (name, phone, email) VALUES ('Wang Wu',  '13800003333', 'wangwu@example.com');

-- Seed data for Address
INSERT INTO address (customer_id, province, city, district, detail, postal_code) VALUES (1, 'Beijing',  'Beijing',   'Haidian',   'No.1 Zhongguancun Street',  '100080');
INSERT INTO address (customer_id, province, city, district, detail, postal_code) VALUES (2, 'Shanghai', 'Shanghai',  'Pudong',    'No.100 Lujiazui Road',     '200120');
INSERT INTO address (customer_id, province, city, district, detail, postal_code) VALUES (3, 'Guangdong', 'Shenzhen', 'Nanshan',   'No.200 Keji South Road',   '518000');

-- Seed data for ProductItem
INSERT INTO product_item (product_name, product_code, price, stock, category) VALUES ('Laptop Computer',     'LT-001',  6999.00, 50, 'Electronics');
INSERT INTO product_item (product_name, product_code, price, stock, category) VALUES ('Wireless Mouse',      'MS-002',  129.00,  200, 'Accessories');
INSERT INTO product_item (product_name, product_code, price, stock, category) VALUES ('Mechanical Keyboard', 'KB-003',  459.00,  120, 'Accessories');
INSERT INTO product_item (product_name, product_code, price, stock, category) VALUES ('USB-C Hub',            'UH-004',  199.00,  300, 'Accessories');

-- Seed data for Order
INSERT INTO t_order (customer_id, customer_name, product_item, address, amount, order_date) VALUES (1, 'Zhang San', 'Laptop Computer',     'No.1 Zhongguancun Street, Haidian, Beijing',   6999.00, '2025-03-01 10:30:00');
INSERT INTO t_order (customer_id, customer_name, product_item, address, amount, order_date) VALUES (2, 'Li Si',    'Wireless Mouse',      'No.100 Lujiazui Road, Pudong, Shanghai',       129.00,  '2025-03-02 14:00:00');
INSERT INTO t_order (customer_id, customer_name, product_item, address, amount, order_date) VALUES (3, 'Wang Wu',  'Mechanical Keyboard', 'No.200 Keji South Road, Nanshan, Shenzhen',    459.00,  '2025-03-03 09:15:00');
INSERT INTO t_order (customer_id, customer_name, product_item, address, amount, order_date) VALUES (1, 'Zhang San', 'USB-C Hub',           'No.1 Zhongguancun Street, Haidian, Beijing',   199.00,  '2025-03-04 16:45:00');
INSERT INTO t_order (customer_id, customer_name, product_item, address, amount, order_date) VALUES (2, 'Li Si',    'Mechanical Keyboard', 'No.100 Lujiazui Road, Pudong, Shanghai',       459.00,  '2025-03-05 11:20:00');
