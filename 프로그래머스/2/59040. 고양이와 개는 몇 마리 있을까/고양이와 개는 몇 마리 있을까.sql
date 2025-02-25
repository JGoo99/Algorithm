/*
where)
종류별로 몇마리
고양이, 개

order)
고양이 먼저
*/

select animal_type, count(animal_id) as count
from animal_ins
where animal_type in ("Cat", "Dog")
group by animal_type
order by animal_type