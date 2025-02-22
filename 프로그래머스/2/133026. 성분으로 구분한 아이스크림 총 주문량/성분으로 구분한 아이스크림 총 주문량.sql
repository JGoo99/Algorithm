/*
where)
성분 타입별로 총주문량

order)
총주문량 asc
*/

select b.ingredient_type, sum(a.total_order) as total_order
from first_half as a
    join icecream_info as b
    on a.flavor = b.flavor
group by b.ingredient_type
order by total_order asc