/*
where)
즐찾수가 가장 많은

음식 종류별로

order)
음식 종류 desc
*/

with sub as (
    select food_type, max(favorites)
    from rest_info
    group by food_type
)

select food_type, rest_id, rest_name, favorites
from rest_info
where (food_type, favorites) in (select * from sub)
order by food_type desc