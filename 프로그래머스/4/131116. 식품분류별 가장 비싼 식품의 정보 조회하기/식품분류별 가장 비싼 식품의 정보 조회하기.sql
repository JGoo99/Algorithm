/*
where)
식품분류별로
가격이 제일 비싼

식품분류 제한사항

order)
식품가격 desc
*/

with sub as (
    select category, max(price)
    from food_product
    where category in ("과자", "국", "김치", "식용유")
    group by category
)

select category, price as max_price, product_name
from food_product
where (category, price) in (select * from sub)
order by max_price desc