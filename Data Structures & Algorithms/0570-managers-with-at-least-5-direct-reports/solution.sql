# Write your MySQL query statement below
select s.name from Employee s
join Employee b
on s.id = b.managerId
group by s.id,s.name
having count(b.id)>=5
