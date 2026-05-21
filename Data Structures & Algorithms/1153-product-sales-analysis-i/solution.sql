# Write your MySQL query statement below
select a.product_name,b.year,b.price from Sales b
inner join Product a
on a.product_id = b.product_id
