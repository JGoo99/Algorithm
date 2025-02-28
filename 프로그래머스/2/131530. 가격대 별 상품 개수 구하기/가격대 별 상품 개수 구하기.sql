/*
where)
만원 단위 가격대 별로 상품개수
*/

select
    floor(price / 10000) * 10000 as price_group,
    count(*) as products
from product
group by price_group
order by price_group