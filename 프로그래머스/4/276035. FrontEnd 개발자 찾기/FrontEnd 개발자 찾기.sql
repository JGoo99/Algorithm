/*
where)
프엔 스킬 개발자

select)
아이디, 이메일, 이름, 성

order)
id asc
*/

with codes as (
    select code
    from skillcodes
    where category = "Front End"
)

select
    distinct id, email, first_name, last_name
from developers as d, codes as c
where skill_code & code
order by id asc