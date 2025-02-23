/*
where)
완료된 중고 거래 총 금액 >= 70만원

order)
총거래금액 asc
*/

with sub as (
    select writer_id, sum(price) as total_sales
    from used_goods_board
    where status = "DONE"
    group by writer_id
    having total_sales >= 700000
)

select
    user_id,
    nickname,
    total_sales
from used_goods_user as a
    join sub as b
    on a.user_id = b.writer_id
order by total_sales asc