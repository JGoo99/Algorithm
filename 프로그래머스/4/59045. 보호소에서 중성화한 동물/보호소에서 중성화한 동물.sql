/*
where)
보호소에 들어올 당시에는 중성화 x
나갈 당시에는 중성화 o

select)
아이디, 생물종, 이름

order)
id asc
*/

select i.animal_id, i.animal_type, i.name
from animal_ins as i
    join animal_outs as o
    on (i.animal_id = o.animal_id)
        and (o.sex_upon_outcome like "Spayed%" or o.sex_upon_outcome like "Neutered%")
where i.sex_upon_intake like "Intact%"
order by i.animal_id