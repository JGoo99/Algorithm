/*
where)
x <= 100 -> LOW
100 < x <= 1000 -> MEDIUM
1000 < x -> HIGH

select)
id, size

order)
id
*/

select
    id,
    case
        when size_of_colony <= 100 then "LOW"
        when size_of_colony <= 1000 then "MEDIUM"
        else "HIGH"
    end as size
from ecoli_data
order by id