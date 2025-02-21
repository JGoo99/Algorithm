/*
where)
평균 대여기간 >= 7일

id, 평균 대여기간 -> 소수 두번째 자리 반올림

order)
평균 대여 기간 desc, id desc
*/

select
    car_id,
    round(avg(datediff(end_date, start_date) + 1), 1) as average_duration
from car_rental_company_rental_history
group by car_id
having average_duration >= 7
order by average_duration desc, car_id desc