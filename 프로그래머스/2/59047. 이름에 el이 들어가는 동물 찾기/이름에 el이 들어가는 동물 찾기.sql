/*
where)
이름에 el 포함
*/

select animal_id, name
from animal_ins
where (name like "%el%") and (animal_type = "DOG")
order by name asc