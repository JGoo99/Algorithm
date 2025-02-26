/*
where)
9:00 ~ 19:59

시간대별로 입양건수

order)
시간대 asc
*/

select hour(datetime) as hour, count(*) as count
from animal_outs
group by hour
having hour > 8 and hour < 20
order by hour