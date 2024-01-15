CREATE DATABASE IF NOT EXISTS restaurant;

USE restaurant;

CREATE TABLE IF NOT EXISTS menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);

INSERT INTO menu (item, price) VALUES
('Item1', 10.99),
('Item2', 8.49),
('Item3', 15.75);


USE restaurant;

CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    item VARCHAR(255) NOT NULL,
    quantity INT NOT NULL
);
