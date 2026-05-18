# Write your MySQL query statement below
select s.product_id 
from Products s
where s.low_fats = "Y" 
And s.recyclable = "Y"
