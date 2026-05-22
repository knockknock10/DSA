# Write your MySQL query statement below
select c.customer_id,count(*) as count_no_trans from Visits c
left join Transactions a
on c.visit_id = a.visit_id
where a.transaction_id is null
group by c.customer_id
