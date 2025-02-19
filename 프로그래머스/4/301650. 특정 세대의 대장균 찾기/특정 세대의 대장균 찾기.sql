select
    sub.third_id as id
from ecoli_data as f
    join (select
                s.id as second_id, s.parent_id second_parent_id,
                t.id as third_id, t.parent_id third_parent_id
               from ecoli_data as s
                join ecoli_data as t
                on s.id = t.parent_id) as sub
    on f.id = sub.second_parent_id
where f.parent_id is null