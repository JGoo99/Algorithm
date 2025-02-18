/*
where)
2022년 3월

select)
오프라인 + 온라인
판매 날짜, 상품아이디, 유저아이디, 판매량
오프라인의 user_id 는 null 로 표시

order)
판매일 asc, 상품id asc, user_id asc
*/

select date_format(a.sales_date, "%Y-%m-%d") as sales_date, a.product_id, a.user_id, a.sales_amount
from online_sale as a
where year(a.sales_date) = 2022 and month(a.sales_date) = 3
union
select date_format(b.sales_date, "%Y-%m-%d") as sales_date, b.product_id, null, b.sales_amount
from offline_sale as b
where year(b.sales_date) = 2022 and month(b.sales_date) = 3
order by sales_date, product_id asc, user_id asc