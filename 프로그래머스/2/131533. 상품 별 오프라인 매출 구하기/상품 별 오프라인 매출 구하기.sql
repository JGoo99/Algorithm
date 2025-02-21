/*
where)
상품코드별 매출액 합계

order)
매출액 desc, 상품코드 asc
*/

select 
    product_code,
    sum(p.price * o.sales_amount) as sales
from product as p
    join offline_sale as o
    on p.product_id = o.product_id
group by product_code
order by sales desc, product_code asc