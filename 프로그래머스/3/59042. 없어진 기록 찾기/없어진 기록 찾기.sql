/*
where)
입양간 기록 o
보호소에 들어온 기록 x

order)
id asc
*/

select animal_id, name
from animal_outs
where animal_id not in (select animal_id
                        from animal_ins)
order by animal_id asc