create schema if not exists netology_new;

create table if not exists netology_new.customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    age INT,
    phone_number VARCHAR(50)
    );

create table if not exists netology_new.orders (
    id SERIAL PRIMARY KEY,
    date DATE,
    customer_id INT,
    product_name VARCHAR(255),
    amount INT,
    FOREIGN KEY (customer_id) REFERENCES netology_new.customers (id)
    );