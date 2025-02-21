/*
where)
2022.10.16 "대여중"
나머지 대여가능

order)
car_id desc
*/

with sub as (
    select car_id
    from car_rental_company_rental_history
    where start_date <= "2022-10-16" and end_date >= "2022-10-16"
)

select
    car_id,
    case
        when car_id in (select * from sub) then "대여중"
        else "대여 가능"
    end as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc