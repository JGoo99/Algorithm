/*
where)
입양을 못간 동물 중
가장 오래 보호소에 있던
3마리

select)
이름, 보호 시작일

order)
보호시작일 asc
*/

select name, datetime
from animal_ins
where animal_id not in (select animal_id
                        from animal_outs)
order by datetime asc
limit 3