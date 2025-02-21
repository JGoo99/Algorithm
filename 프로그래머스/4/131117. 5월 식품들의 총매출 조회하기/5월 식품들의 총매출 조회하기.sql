/*
where)
produce_date = 2022.5

order)
총 매출 desc, id asc
*/

with sub as (
    select product_id, sum(amount) as amount
    from food_order as o
    where year(o.produce_date) = 2022 and month(o.produce_date) = 5
    group by product_id
)

select
    p.product_id,
    p.product_name,
    s.amount * p.price as total_sales
from food_product as p
    join sub as s
    on p.product_id = s.product_id
order by total_sales desc, product_id asc