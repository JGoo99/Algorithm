/*
where)
grade 별 개발자 정보

order)
grade asc, id asc
*/

with sub as (
    select *
    from skillcodes s, developers d
    where (s.code & d.skill_code > 0)
),
dev_a as (
    select *
    from sub
    where (category = "Front End")
        and ((select code from skillcodes where name = "Python") & skill_code > 0)
),
dev_b as (
    select *
    from sub
    where (select code from skillcodes where name = "C#") & skill_code > 0
),
dev_c as (
    select *
    from sub
    where (category = "Front End")
        and (id not in (select id from dev_a))
)

select
    case
        when id in (select id from dev_a) then 'A'
        when id in (select id from dev_b) then 'B'
        when id in (select id from dev_c) then 'C'
    end as grade,
    id, email
from sub
group by id, email
having grade is not null
order by grade asc, id asc