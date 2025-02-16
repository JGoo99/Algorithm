/*
조건)
x 생일이 3월
x 여성
전화번호 null -> 출력 x

정렬)
회원 id
*/

select
    member_id,
    member_name,
    gender,
    date_format(date_of_birth, "%Y-%m-%d") as date_of_birth
from member_profile
where 
    month(date_of_birth) = 3 
    and gender = "W"
    and tlno is not null
order by member_id