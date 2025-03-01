/*
where)
0~23시 까지
각 시간대별로 입양 건수

order)
시간대 asc
*/

set @hour = -1;

select
    (@hour := @hour + 1) as hour,
    (select count(*)
     from animal_outs
     where @hour = hour(datetime)) as count
from animal_outs
where @hour < 23;