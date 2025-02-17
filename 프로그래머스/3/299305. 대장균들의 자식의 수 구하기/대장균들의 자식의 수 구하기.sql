/*
select)
id, 자식의 수(child_count)

where)
자식이 없으면 0으로

order)
id asc
*/

select a.id, count(b.id) as child_count
from ecoli_data as a
    left join ecoli_data as b
    on a.id = b.parent_id
group by a.id
order by a.id asc