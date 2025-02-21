/*
select)
top 3 맛

order)
7월 총 주문량 + 상반기 총 주문량 desc
*/

select f.flavor
from first_half as f
    left join july as j
    on f.flavor = j.flavor
group by f.flavor
order by (sum(f.total_order) + sum(f.total_order)) desc
limit 3