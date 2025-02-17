/*
order)
id asc

where)
size_of_colony
0-25 "CRITICAL"
26-50 "HIGH"
51-75 "MEDIUM"
76-100 "LOW"

select)
id, clony_name

데이터 수는 4의 배수
같은 사이즈
*/

select 
    id,
    case
        when size_rank = 1 then "CRITICAL"
        when size_rank = 2 then "HIGH"
        when size_rank = 3 then "MEDIUM"
        else "LOW"
    end as colony_name
from (select 
        id, 
        ntile(4) over (order by size_of_colony desc) as size_rank
      from ecoli_data) as sub
order by id
