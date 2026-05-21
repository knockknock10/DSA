# Write your MySQL query statement below
select a.unique_id,b.name from Employees b
left join EmployeeUNI a
on a.id=b.id

