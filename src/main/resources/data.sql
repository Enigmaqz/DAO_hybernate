insert into postgres.netology_new.customers(
    name,
    surname,
    age,
    phone_number
) values
      ('Vova', 'Lojkin', 12, '+79999999999'),
      ('Katia', 'Pirogova', 15, '+78888888888');

insert into postgres.netology_new.orders(
    date,
    customer_id,
    product_name,
    amount
) values
      (current_date, 1, 'Samokat', 1),
      (current_date, 2, 'Postolet', 1),
      (current_date, 1, 'Pirog', 2)
;