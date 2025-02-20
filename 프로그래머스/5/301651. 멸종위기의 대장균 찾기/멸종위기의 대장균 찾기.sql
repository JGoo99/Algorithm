/*
select)
각 세대별 자식이 없는 개체 수 count
세대 generation

ordre)
generation asc
*/

with recursive tmp as (
    select a.id as id, a.parent_id as parent_id, 1 as generation
    from ecoli_data as a
    where a.parent_id is null
    union all
    select b.id as id, b.parent_id as parent_id, tmp.generation + 1 as generation
    from tmp
        join ecoli_data as b
        on tmp.id = b.parent_id
)

select count(*) as count, t.generation as generation
from tmp as t
where t.id not in (select distinct parent_id
                   from tmp
                   where parent_id is not null)
group by t.generation