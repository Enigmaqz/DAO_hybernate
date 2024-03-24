select o.product_name from netology_new.orders o
join netology_new.customers c on o.customer_id = c.id
where lower(c.name) = lower(:name);